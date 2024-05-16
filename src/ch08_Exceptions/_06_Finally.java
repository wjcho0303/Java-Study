package ch08_Exceptions;

// finally 블럭 { }에는 예외가 발생하든 발생하지 않든 수행시킬 코드를 넣는다.
// finally 블럭은 try-catch 문의 맨 마지막에 위치해야 한다.

//                try {
//                    startInstall();
//                    copyFiles();
//                    deleteTempFiles();  <--- 이건 반드시 수행해야 하는 경우
//                } catch (Exception e){
//                    e.printStackTrace();
//                    deleteTempFiles();
//                }

// 위와 같이 쓰면 deleteTempFiles(); 코드가 중복된다.

//                try {
//                    startInstall();
//                    copyFiles();
//                } catch (Exception e){
//                    e.printStackTrace();
//                } finally {
//                    deleteTempFiles();
//                }

// 이렇게 finally 를 사용함으로써 반드시 수행하고 싶은 코드가 try 와 catch 에 중복되어 작성되는 것을 방지할 수 있다.
public class _06_Finally {
}
