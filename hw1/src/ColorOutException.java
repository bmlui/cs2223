public class ColorOutException extends InvalidInputException{
    String color;
    public ColorOutException(String color) {
        this.color = color;
    }

    public String getColor() {
        return this.color;
    }

}
