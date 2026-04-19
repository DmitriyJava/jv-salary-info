package core.basesyntax;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SalaryInfo {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private static final int INITIAL_SALARY = 0;
    private static final int DATE_INDEX = 0;
    private static final int NAME_INDEX = 1;
    private static final int HOURS_INDEX = 2;
    private static final int INCOME_INDEX = 3;

    public String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        StringBuilder result = new StringBuilder();
        result.append("Report for period ").append(dateFrom).append(" - ").append(dateTo);
        LocalDate from = LocalDate.parse(dateFrom, FORMATTER);
        LocalDate to = LocalDate.parse(dateTo, FORMATTER);

        for (String name : names) {
            int totalSalary = INITIAL_SALARY;

            for (String entry : data) {
                String[] parts = entry.split(" ");
                LocalDate currentDate = LocalDate.parse(parts[DATE_INDEX], FORMATTER);
                String currentName = parts[NAME_INDEX];
                int hours = Integer.parseInt(parts[HOURS_INDEX]);
                int salary = Integer.parseInt(parts[INCOME_INDEX]);
                if (currentName.equals(name) && !currentDate.isBefore(from) && !currentDate
                        .isAfter(to)) {
                    totalSalary += hours * salary;
                }
            }
            result.append(System.lineSeparator()).append(name).append(" - ").append(totalSalary);
        }
        return result.toString();
    }
}

