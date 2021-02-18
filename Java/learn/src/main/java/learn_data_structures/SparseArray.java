package learn_data_structures;

public class SparseArray {

    /**
     * 创建一个二维数组
     * @return 创建后的数组
     */
    public int[][] createArray(){
        int [][] array = new int[11][10];
        array[1][2] = 1;
        array[2][4] = 2;
        // 打印
        System.out.println("创建数组：");
        for (int []row : array) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        return array;
    }

    /**
     * 将数组转为稀疏数组
     * @param originalArray 原始的数组
     * @param defaultValue 原始数组的默认填充值
     * @return 转化后的数组
     */
    public int[][] trans2SparseArray(int[][] originalArray, int defaultValue) {
        // 1、获取【差异值】的个数
        int sum = 0;
        for (int[] row : originalArray) {
            for (int data : row) {
                if (data != 0) { sum+=1; }
            }
        }

        // 2、创建稀疏数组。
        // 行数为元素个数+1，因为多处的第一行要存放原数组的大小
        // 列数为三列。对于第一行而言，每列分别为行数、列数、默认值。对于后续行，每列分别为行号、列号、值
        int[][] sparseArray = new int[sum+1][3];
        int rowCount = originalArray.length;
        int colCount = originalArray[0].length;
        sparseArray[0][0] = rowCount;
        sparseArray[0][1] = colCount;
        sparseArray[0][2] = 0;

        // 3、将非0元素放入稀疏数组
        int k = 1, temp;
        for (int i=0; i<rowCount; i++) {
            for (int j=0; j<colCount; j++) {
                temp = originalArray[i][j];
                if (temp != defaultValue) {
                    sparseArray[k][0] = i;
                    sparseArray[k][1] = j;
                    sparseArray[k][2] = temp;
                    k++;
                }
            }
        }

        // 打印
        System.out.println("原始数组转化后得到稀疏数组：");
        for (int []row : sparseArray) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        return sparseArray;
    }

    public int[][] trans2OriginalArray(int[][] sparseArray) {
        // 1、读取大小创建数组，读取默认值进行填充
        int rowCount = sparseArray[0][0];
        int colCount = sparseArray[0][1];
        int defaultValue = sparseArray[0][2];
        int [][] originalArray = new int[rowCount][colCount];
        for (int i=0; i<rowCount; i++) {
            for (int j=0; j<colCount; j++) {
                originalArray[i][j] = defaultValue;
            }
        }

        // 2、读取差异值进行赋值
        int rolNum, colNum, value;
        for (int i=1; i<sparseArray.length; i++) {
            rolNum = sparseArray[i][0];
            colNum = sparseArray[i][1];
            value = sparseArray[i][2];
            originalArray[rolNum][colNum] = value;
        }

        // 打印
        System.out.println("稀疏数组还原后得到原始数组：");
        for (int []row : originalArray) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }

        return originalArray;
    }


    public static void main(String[] args) {
        // 场景：棋盘，大小是 11 * 11
        SparseArray sparseArray = new SparseArray();

        // 1、创建二维数组，0是无棋子、1是黑子、2是白子
        int[][] chessArr= sparseArray.createArray();
        int[][] sparseArr = sparseArray.trans2SparseArray(chessArr, 0);
        chessArr = sparseArray.trans2OriginalArray(sparseArr);
    }
}
