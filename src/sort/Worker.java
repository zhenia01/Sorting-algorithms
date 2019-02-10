package sort;

class Worker implements Comparable<Worker> {

    private int salary;
    private String name;

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public Worker(String name, int salary) {
        this.salary = salary;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Worker{" +
                "salary=" + salary +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Worker o) {
        return this.salary - o.getSalary();
    }
}