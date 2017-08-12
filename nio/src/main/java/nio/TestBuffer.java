package nio;

import java.nio.IntBuffer;

/**
 * Created by Administrator on 2017/8/3.
 */
public class TestBuffer {

    public static void main(String[] args){
        IntBuffer intBuffer=IntBuffer.allocate(10);
        intBuffer.put(13);
        intBuffer.put(15);
        intBuffer.put(20);
        intBuffer.flip();
        System.out.println("使用flip复位:" + intBuffer);
        System.out.println("容量为:" + intBuffer.capacity());
        System.out.println("限制为:" + intBuffer.limit());
    }
}
