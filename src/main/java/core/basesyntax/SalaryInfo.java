package core.basesyntax;

public class SalaryInfo {

    String getSalaryInfo(String[] names, String[] data, String dateFrom, String dateTo) {
        int from = convertDateToInt(dateFrom);
        int to = convertDateToInt(dateTo);
        StringBuilder result = new StringBuilder();
        result.append("Report for period ").append(dateFrom).append(" - ").append(dateTo);

        for (String name : names) {
            int totalSalary = 0;

            for (String entry : data) {
                String[] parts = entry.split(" ");
                int currentDate = convertDateToInt(parts[0]);
                String currentName = parts[1];
                int hours = Integer.parseInt(parts[2]);
                int salary = Integer.parseInt(parts[3]);
                if (currentName.equals(name) && currentDate >= from && currentDate <= to) {
                    totalSalary += hours * salary;
                }
            }
            result.append(System.lineSeparator())
                    .append(name)
                    .append(" - ")
                    .append(totalSalary);
        }

        return result.toString();
    }

    int convertDateToInt(String date) {
        String[] parts = date.split("\\.");
        String sortedDate = parts[2] + parts[1] + parts[0];
        return Integer.parseInt(sortedDate);
    }
}
