import java.util.Objects;

public class Laptop {
    private String name;
    private String system;
    private int sizeRam;
    private int sizeHdd;
    private String color;

    public Laptop(String name, String system, int sizeRam, int sizeHdd, String color) {
        this.name = name;
        this.system = system;
        this.sizeRam = sizeRam;
        this.sizeHdd = sizeHdd;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public int getSizeRam() {
        return sizeRam;
    }

    public void setSizeRam(int sizeRam) {
        this.sizeRam = sizeRam;
    }

    public int getSizeHdd() {
        return sizeHdd;
    }

    public void setSizeHdd(int sizeHdd) {
        this.sizeHdd = sizeHdd;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "Название='" + name + '\'' +
                ", Операционнай система='" + system + '\'' +
                ", Размер ОЗУ=" + sizeRam +" GB" +
                ", Размер HDD=" + sizeHdd +" GB"+
                ", Цвет='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptot = (Laptop) obj;
        return sizeRam == laptot.sizeRam &&
                sizeHdd == laptot.sizeHdd &&
                Objects.equals(name, laptot.name) &&
                Objects.equals(system, laptot.system) &&
                Objects.equals(color, laptot.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, system, sizeRam, sizeHdd, color);
    }

}