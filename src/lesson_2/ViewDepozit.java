package lesson_2;
//вид депозита
public class ViewDepozit {
    private String kod;
    private String nameDepozit;

    public ViewDepozit(String kod, String nameDepozit) {
        this.kod = kod;
        this.nameDepozit = nameDepozit;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getNameDepozit() {
        return nameDepozit;
    }

    public void setNameDepozit(String nameDepozit) {
        this.nameDepozit = nameDepozit;
    }
}
