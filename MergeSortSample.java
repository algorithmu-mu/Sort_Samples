/*

マージソート

計算量: O(Nlog(N))

*/



class MergeSortSample {
  public static void main(String[] args) {
    System.out.println("hoge");
    int[] arr = {3, 2, 5, 6, 1, 4, 7, 0};
    mergeSort(arr);
    printArray(arr);
  }

  public static void mergeSort(int[] arr) {
    if (arr.length > 1) {

      //２つに配列を分けた時のそれぞれの配列の要素を算出
      int leftArrCount = arr.length / 2;
      int rightArrCount = arr.length - leftArrCount;

      //上記の数が格納できる配列を作成
      int[] leftArr = new int[leftArrCount];
      int[] rightArr = new int[rightArrCount];

      //arrを作成した２つの配列に分ける
      for (int i = 0; i < leftArrCount; i++) {
        leftArr[i] = arr[i];
      }
      for (int i = 0; i < rightArrCount; i++) {
        rightArr[i] = arr[i + leftArrCount];
      }

      //再帰的に配列を分割
      mergeSort(leftArr);
      mergeSort(rightArr);
      
      //要素の入れ替え
      merge(leftArr, rightArr, arr);
      printArray(arr);
      
    }
  }

  public static void merge(int[] leftArr, int[] rightArr, int[] arr) {
    //左右の配列をチェックしたか否かを管理するインデックスを用意
    int leftCheckIndex = 0;
    int rightCheckIndex = 0;

    //左右の配列の全ての要素をチェックするまで繰り返し
    while (leftCheckIndex < leftArr.length || rightCheckIndex < rightArr.length) {

      //前半: 右配列の要素を全てチェックしたという条件
      //後半: 左配列の要素をまだ全てチェックしていない　且つ チェックしている要素において右右配列の要素の方が大きい場合
      if (rightCheckIndex >= rightArr.length || (leftCheckIndex < leftArr.length && leftArr[leftCheckIndex] < rightArr[rightCheckIndex])) {
        
        //この条件は左配列の要素の方が小さいので、左配列の要素を挿入
        arr[leftCheckIndex + rightCheckIndex] = leftArr[leftCheckIndex];
        leftCheckIndex++; //左配列の要素をチェック
      } else {
        arr[leftCheckIndex + rightCheckIndex] = rightArr[rightCheckIndex];
        rightCheckIndex++;
      }
    }
  }

  public static void printArray(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + ",");
    }
    System.out.println();
  }


}

//ちょっと違う
class Meee {
  public static void main(String[] args) {
    int[] arr = {3, 1, 6, 5};
    printArr(arr);
    mergeSort(arr);
    printArr(arr);
  }

  public static void mergeSort(int[] arr) {

    if (arr.length > 1) {
      int leftCount = arr.length / 2;
      int rightCount = arr.length - leftCount;

      int[] leftArr = new int[leftCount];
      int[] rightArr = new int[rightCount];

      for (int i = 0; i < leftCount; i++) {
        leftArr[i] = arr[i];
      }
      for (int i = 0; i < rightCount; i++) {
        rightArr[i] = arr[i + leftCount];
      }

      mergeSort(leftArr);
      mergeSort(rightArr);

      merge(leftArr, rightArr, arr);
      printArr(arr);
    }

  }

  public static void merge(int[] leftArr, int[] rightArr, int[] arr) {
    int i = 0;
    int j = 0;

    while (leftArr.length > i && rightArr.length > j) {
      if (leftArr[i] > rightArr[j]) {
        arr[i + j] = rightArr[j];
        j++;
      } else {
        arr[i + j] = leftArr[i];
        i++;
      }
    }

    while (leftArr.length > i) {
      arr[i + j] = leftArr[i];
      i++;
    }
    while (rightArr.length > j) {
      arr[i + j] = rightArr[j];
      j++;
    }
  }

  public static void printArr(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(" " + arr[i]);
    }
    System.out.println();
  }
}

