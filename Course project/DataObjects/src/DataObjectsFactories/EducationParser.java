package DataObjectsFactories;

import education.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by aizeeck on 26.05.17.
 */
public class EducationParser {

    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d.M.yyyy");

    private EducationParser() {}

    public static List<Education> createEducation(String[] command) {
        List<Education> educations = new ArrayList<>();
        List<String> eduStrings = new ArrayList<>();
        for (int i = 14; i < command.length; i++) {
            if (command[i].length() == 1) {
                eduStrings.add(command[i]);
                i++;
            }
            eduStrings.add(command[i]);
            if (i == command.length - 1 || command[i + 1].length() == 1) {
                educations.add(getEducation(eduStrings));
                eduStrings.clear();
            }
        }
        return educations;
    }

    public static Education getEducation(List<String> eduStrings) {
        Education education = null;
        switch (eduStrings.get(0)) {
            case "P":
                education = new PrimaryEducation(
                        eduStrings.get(1),
                        LocalDate.parse(eduStrings.get(2), formatter),
                        LocalDate.parse(eduStrings.get(3), formatter)
                );
                break;
            case "S":
                education = new SecondaryEducation(
                        eduStrings.get(1),
                        LocalDate.parse(eduStrings.get(2), formatter),
                        LocalDate.parse(eduStrings.get(3), formatter)
                );
                break;
            case "B":
                education = new HigherEducation(
                        eduStrings.get(1),
                        LocalDate.parse(eduStrings.get(2), formatter),
                        LocalDate.parse(eduStrings.get(3), formatter),
                        EducationDegree.valueOf("Bachelor")
                );
                break;
            case "M":
                education = new HigherEducation(
                        eduStrings.get(1),
                        LocalDate.parse(eduStrings.get(2), formatter),
                        LocalDate.parse(eduStrings.get(3), formatter),
                        EducationDegree.valueOf("Master")
                );
                break;
            case "D":
                education = new HigherEducation(
                        eduStrings.get(1),
                        LocalDate.parse(eduStrings.get(2), formatter),
                        LocalDate.parse(eduStrings.get(3), formatter),
                        EducationDegree.valueOf("Doctorate")
                );
                break;
        }

        if (education instanceof PrimaryEducation || eduStrings.size() < 5) {
            return education;
        } else {
            ((GradedEducation) education).gotGraduated(Float.parseFloat(eduStrings.get(4)));
            return education;
        }
    }

    public static Education createEducation(Map<String, String[]> eduMap) {
        Education education = null;
        switch (eduMap.get("educationType")[0]) {
            case "primary":
                if (!eduMap.get("finalGrade")[0].isEmpty()) {
                    throw new IllegalArgumentException("It is NOT expected the finalGrade to be provided for PRIMARY education.");
                }
                education = new PrimaryEducation(
                        eduMap.get("institutionName")[0],
                        LocalDate.parse(eduMap.get("enrollmentDate")[0], formatter),
                        LocalDate.parse(eduMap.get("graduationDate")[0], formatter)
                );
                break;
            case "secondary":
                education = new SecondaryEducation(
                        eduMap.get("institutionName")[0],
                        LocalDate.parse(eduMap.get("enrollmentDate")[0], formatter),
                        LocalDate.parse(eduMap.get("graduationDate")[0], formatter)
                );
                break;
            case "bachelor":
                education = new HigherEducation(
                        eduMap.get("institutionName")[0],
                        LocalDate.parse(eduMap.get("enrollmentDate")[0], formatter),
                        LocalDate.parse(eduMap.get("graduationDate")[0], formatter),
                        EducationDegree.valueOf("Bachelor")
                );
                break;
            case "master":
                education = new HigherEducation(
                        eduMap.get("institutionName")[0],
                        LocalDate.parse(eduMap.get("enrollmentDate")[0], formatter),
                        LocalDate.parse(eduMap.get("graduationDate")[0], formatter),
                        EducationDegree.valueOf("Master")
                );
                break;
            case "doctorate":
                education = new HigherEducation(
                        eduMap.get("institutionName")[0],
                        LocalDate.parse(eduMap.get("enrollmentDate")[0], formatter),
                        LocalDate.parse(eduMap.get("graduationDate")[0], formatter),
                        EducationDegree.valueOf("Doctorate")
                );
                break;
        }

        if (education instanceof PrimaryEducation) {
            return education;
        } else {
            if (LocalDate.now().compareTo(education.getGraduationDate()) < 0 && !eduMap.get("finalGrade")[0].isEmpty()) {
                throw new IllegalArgumentException("GraduationDate is in future. It is NOT expected the finalGrade to be provided.");
            }
            if (LocalDate.now().compareTo(education.getGraduationDate()) < 0) {
                return education;
            } else if(!eduMap.get("finalGrade")[0].isEmpty()) {
                ((GradedEducation) education).gotGraduated(Float.parseFloat(eduMap.get("finalGrade")[0]));
                return education;
            }
            throw new IllegalArgumentException("GraduationDate is past. It is expected the finalGrade to be provided.");
            
        }
    }
}
