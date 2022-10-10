class MyClass{
    public static void main(String[] args){
        RGB color1 = new RGB (0, 153, 255);
        System.out.println(color1.getHexCode());
        System.out.println(color1.getBits());
        System.out.println(color1.getColorShade());

        RGB color2 = new RGB(255, 153, 204);
        System.out.println (color2.getHexCode());
        System.out.println (color2.getBits());
        System.out.println (color2.getColorShade());

        RGB color3 = new RGB (0, 87, 0);
        System.out.println (color3.getHexCode());
        System.out.println (color3.getBits());
        System.out.println (color3.getColorShade());

        RGB gray = new RGB (123, 123, 123);
        System.out.println (gray.getHexCode());
        System.out.println (gray.getBits());
        System.out.println (gray.getColorShade());
    }
}

class RGB {
    public int red;
    public int green;
    public int blue;

    public RGB (int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public String getHexCode () {
        String sixString = "0123456789abcdef";
        String str = "";
        String str2 = "";
        String str3 = "";
        int digitRed = this.red;
        int digitGreen = this.green;
        int digitBlue = this.blue;

        while (digitRed >= 0) {
            int curretDigit = 0;
            curretDigit = digitRed % 16;
            if (digitRed <= 0) str = "0";
            str = sixString.charAt(curretDigit) + str;
            digitRed = digitRed / 16;
            if (digitRed == 0) break;
        }

        while (digitGreen >= 0) {
            int curretDigit = 0;
            curretDigit = digitGreen % 16;
            if (digitGreen <= 0) str2 = "0";
            str2 = sixString.charAt(curretDigit) + str2;
            digitGreen = digitGreen / 16;
            if (digitGreen == 0) break;
        }

        while (digitBlue >= 0) {
            int curretDigit = 0;
            curretDigit = digitBlue % 16;
            if (digitBlue <= 0) str3 = "0";
            str3 = sixString.charAt(curretDigit) + str3;
            digitBlue = digitBlue / 16;
            if (digitBlue == 0) break;
        }
        return "#" + str + str2 + str3;
    }

    public String getBits () {
        String bits = "";
        String bits2 = "";
        String bits3 = "";
        int currentBinary = 0;
        int digitRed = this.red;
        int digitGreen = this.green;
        int digitBlue = this.blue;
        while (digitRed > 0) {
            currentBinary = digitRed % 2;
            bits = currentBinary + bits;
            digitRed /= 2;
            if (digitRed == 0) break;
        }
        while (digitGreen > 0) {
            currentBinary = digitGreen % 2;
            bits2 = currentBinary + bits2;
            digitGreen /= 2;
            if (digitGreen == 0) break;
        }
        while (digitBlue > 0) {
            currentBinary = digitBlue % 2;
            bits3 = currentBinary + bits3;
            digitBlue /= 2;
            if (digitBlue == 0) break;
        }
       
        if (this.blue == 0) {
            return bits + bits2 + bits3 + "00000000";
        }
        if (this.red == 0) {
            return bits2 + bits3;
        }
        if (this.red == this.blue && this.blue == this.green) {
            return bits + "0" + bits2 + "0" + bits3;
        }

        return bits + bits2 + bits3;
    }

    public String getColorShade () {
        int scaleRed = this.red;
        int scaleGreen = this.green;
        int scaleBlue = this.blue;
        String str = "";
        if (scaleRed == scaleBlue && scaleBlue == scaleGreen) str = "grayscale";
        if (scaleRed > scaleBlue && scaleRed > scaleBlue) str = "red";
        if (scaleBlue > scaleRed && scaleBlue > scaleGreen) str =  "blue";
        if (scaleGreen > scaleRed && scaleGreen > scaleBlue) str =  "green"; 

        return str;
    }
}
