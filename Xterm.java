import java.io.*;
public class Xterm {
    private static final DataInputStream in =
            new DataInputStream(System.in);
    private static final int MAXLEN = 255;
    private static String inputString() throws IOException {
        byte buf[] = new byte[MAXLEN];
        int i = in.read(buf);
        return new String(buf,0,i-1);
    }

    public static final int Black = 0;
    public static final int Red = 1;
    public static final int Green = 2;
    public static final int Yellow = 3;
    public static final int Blue = 4;
    public static final int Magenta = 5;
    public static final int Cyan = 6;
    public static final int White = 7;

    public static void clear() {
        System.out.print("\0332J");
    }

    public static void setPosition(int x, int y) {
        System.out.print(" " + (y+1) + ";" + (x+1) + "H");
    }

    public static void print(String txt) {
        System.out.print(" "+txt+" ");
    }
    public static void print(String txt, int fg) {
        System.out.print(" " + (30+fg)
                + txt + " ");
    }
    public static void print(String txt, int fg, int bg) {
        System.out.print(" "+(bg==7?"":""+(40+bg)+";")+
                (30+fg) + txt + " ");
    }
    public static void println(String txt) {
        System.out.println(" "+txt+" ");
    }
    public static void println(String txt, int fg) {
        System.out.println(" " + (30+fg)
                + txt + " ");
    }
    public static void println(String txt, int fg, int bg) {
        System.out.println(" "+(bg==7?"":""+(40+bg)+";")+
                (30+fg) + txt + " ");
    }

    public static int inputInt() throws IOException,
            NumberFormatException {
        return Integer.valueOf(inputString()).intValue();
    }
    public static int inputInt(String prompt) throws IOException,
            NumberFormatException {
        print(prompt); return inputInt();
    }
    public static long inputLong() throws IOException,
            NumberFormatException {
        return Long.valueOf(inputString()).longValue();
    }
    public static long inputLong(String prompt) throws IOException,
            NumberFormatException {
        print(prompt); return inputLong();
    }
    public static float inputFloat() throws IOException,
            NumberFormatException {
        return Float.valueOf(inputString()).floatValue();
    }
    public static float inputFloat(String prompt) throws IOException,
            NumberFormatException {
        print(prompt); return inputFloat();
    }
    public static double inputDouble() throws IOException,
            NumberFormatException {
        return Double.valueOf(inputString()).doubleValue();
    }
    public static double inputDouble(String prompt)
            throws IOException, NumberFormatException {
        print(prompt); return inputDouble();
    }

    public static char[] inputChars() throws IOException {
        return (inputString()).toCharArray();
    }
    public static char[] inputChars(String prompt)
            throws IOException {
        print(prompt);
        return (inputString()).toCharArray();
    }
}