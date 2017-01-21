package com.smertbox.util.nio;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelFileReader {

	private FileInputStream fileInputStream;
    private ByteBuffer byteBuffer;
    private long fileLength;
    private int bufferSize;
    private byte[] array;

    public ChannelFileReader(String fileName, int bufferSize) throws IOException {
        this.fileInputStream = new FileInputStream(fileName);
        this.fileLength = fileInputStream.getChannel().size();
        this.bufferSize = bufferSize;
        this.byteBuffer = ByteBuffer.allocate(this.bufferSize);
    }

    public int read() throws IOException {
        FileChannel fileChannel = fileInputStream.getChannel();
        int bytes = fileChannel.read(byteBuffer);// 读取到ByteBuffer中
        if (bytes != -1) {
            array = new byte[bytes];// 字节数组长度为已读取长度
            byteBuffer.flip();
            byteBuffer.get(array);// 从ByteBuffer中得到字节数组
            byteBuffer.clear();
            return bytes;
        }
        return -1;
    }

    public void close() throws IOException {
        fileInputStream.close();
        array = null;
    }

    public byte[] getArray() {
        return array;
    }

    public long getFileLength() {
        return fileLength;
    }

    public static void main(String[] args) throws IOException {
        ChannelFileReader reader = new ChannelFileReader("H:/迅雷下载/[电影天堂www.dy2018.com]了不起的盖茨比BD中英.rmvb", 1024);
        long start = System.nanoTime();
        while (reader.read() != -1) ;
        long end = System.nanoTime();
        reader.close();
        System.out.println("ChannelFileReader: " + (end - start));
    }
	
}
