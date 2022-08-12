package sg.edu.rp.c346.id21020263.p13ps;

public class Waste {
    private String recycled;
    private String disposed;
    private String year;

    public Waste(String recycled, String disposed, String year) {
        this.recycled = recycled;
        this.disposed = disposed;
        this.year = year;
    }

    public String getRecycled() {
        return recycled;
    }

    public void setRecycled(String recycled) {
        this.recycled = recycled;
    }

    public String getDisposed() {
        return disposed;
    }

    public void setDisposed(String disposed) {
        this.disposed = disposed;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Waste\n" +
                "recycled: " + recycled + '\n' +
                "disposed: " + disposed + '\n' +
                "year: " + year;
    }
}
