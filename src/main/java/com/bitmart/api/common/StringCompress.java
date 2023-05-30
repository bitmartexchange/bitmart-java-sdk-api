package com.bitmart.api.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.Unpooled;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.zip.Inflater;
public class StringCompress {
    private static final Logger log = LoggerFactory.getLogger(StringCompress.class);
    private static String uncompress(ByteBuf buf) {
        try {
            byte[] temp = new byte[buf.readableBytes()];
            ByteBufInputStream bis = new ByteBufInputStream(buf);
            bis.read(temp);
            bis.close();
            Inflater decompresser = new Inflater(true);
            decompresser.setInput(temp, 0, temp.length);
            StringBuilder sb = new StringBuilder();
            byte[] result = new byte[1024];
            while (!decompresser.finished()) {
                int resultLength = decompresser.inflate(result);
                sb.append(new String(result, 0, resultLength, "UTF-8"));
            }
            decompresser.end();
            return sb.toString();
        }catch (Exception e) {
            log.error("uncompress exception", e);
        }
        return "";
    }

    public static String decode(ByteBuf content){
        byte[] bytes = new byte[content.readableBytes()];
        content.readBytes(bytes);
        ByteBuf byteBuf = Unpooled.wrappedBuffer(bytes);
        String str = uncompress(byteBuf);
        return str;
    }

}
