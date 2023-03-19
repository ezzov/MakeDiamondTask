public class Main {
    public static void main(String[] args) {
        int w = 1;
        int h = 30;
        for (int i = 0; i < 79; i++) {
            printDiamond(h, w);
            w++;
            System.out.println();
        }
    }

    private static void printDiamond(int height, int width) {
        int centerWidth = width / 2 - 1 + width % 2;
        int indent = findIndent(height, width);
        int firstMargin = centerWidth - indent;
        for (int i = 0; i < height; i++) {
            if (width < 3) {
                System.out.println("#".repeat(2 - width % 2));
            } else {
                if (i == 0 || i == height - 1) {
                    System.out.printf(" ".repeat(centerWidth) + "#".repeat(2 - width % 2) + "%n");
                } else if (isMiddleHeight(i, height, width)) {
                    System.out.printf("#" + " ".repeat(width - 2) + "#%n");
                } else {
                    System.out.printf(" ".repeat(firstMargin) + "#");

                    int secondMargin = width - 2 * firstMargin - 2;
                    if (secondMargin < 1) {
                        secondMargin = 0;
                    }
                    if (i < height /2 - 1 + height % 2) {
                        firstMargin -= indent;
                    } else {
                        firstMargin += indent;
                    }
                    if (firstMargin < indent) {
                        firstMargin = indent;
                    }

                    System.out.printf(" ".repeat(secondMargin) + "#" + "%n");
                }
            }
        }
    }

    private static int findIndent(int height, int width) {
        if (Math.round((float) width / height) == 0) {
            return 1;
        }
        return Math.round((float) width / height);
    }

    private static boolean isMiddleHeight(int i, int height, int width) {
        int firstMargin = width / 2 - 1 + width % 2 - findIndent(height, width);
        if (width > height) {
            return i == height / 2 || i == height / 2 - 1 + height % 2;
        } else {
            return i > (firstMargin) && i < (height - (1 + height % 2) - (firstMargin));
        }
    }
}
