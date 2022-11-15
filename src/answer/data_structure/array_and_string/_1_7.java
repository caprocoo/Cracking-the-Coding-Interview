package answer.data_structure.array_and_string;

//1.7 MxN 행렬을 순회하면서 0인 원소를 발견하면, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을 작성하라

public class _1_7 {

    public int [][] changeMatrix(int [][] arr){
        if(arr.length==0) return arr;
        
        boolean [] b1 = new boolean[arr.length];
        boolean [] b2 = new boolean[arr[0].length];

        //arr에 0이 있는 경우 true값 넣기
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(arr[i][j]==0){
                    b1[i] = true;
                    b2[i] = true;
                }
            }
        }
        
        // row 혹은 col이 하나라도 true인 경우 arr에 0 적용 
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(b1[i] || b2[j]){
                    arr[i][j] = 0;
                }
            }
        }
        // arr 출력 for문
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j]);
            }
            System.out.println("");
        }
        return arr;
    }
    public static void main(String[] args) {
        _1_7 main = new _1_7();
        int [][] matrix = {{0,1,1,1,1},{2,2,2,2,2},{3,3,3,3,3}};
        main.changeMatrix(matrix);

    }
}
