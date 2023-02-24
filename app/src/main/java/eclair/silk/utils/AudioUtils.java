package eclair.silk.utils;

import android.os.Environment;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import eclair.silk.coder.LameCoder;
import eclair.silk.coder.MP3Coder;
import eclair.silk.coder.SilkCoder;

public class AudioUtils {
    static {
        System.loadLibrary("lame");
        System.loadLibrary("silk");
        System.loadLibrary("mp3");
    }

    public static File mp3ToSilk(File mp3File) throws IOException {
        return mp3ToSilk(mp3File, 24000);
    }

    public static File mp3ToSilk(File mp3File, int bitRate) throws IOException {
        File pcmFile = getTempFile(mp3File, "pcm");
        File silkFile = getTempFile(mp3File, "silk");
        if (silkFile.exists()) {
            throw new IOException(":已存在同名文件");
        }
        int sampleRate = MP3Coder.decode(mp3File.getAbsolutePath(), pcmFile.getAbsolutePath(), 1, 24000);
        SilkCoder.encode(pcmFile.getAbsolutePath(), silkFile.getAbsolutePath(), sampleRate, bitRate);
        pcmFile.delete();
        return silkFile;
    }

    public static File silkToMp3(File silkFile, int bitrate) throws IOException {
        File pcmFile = getTempFile(silkFile, "pcm");
        File mp3File = getTempFile(silkFile, "mp3");
        if (mp3File.exists()) {
            throw new IOException(":已存在同名文件");
        }
        SilkCoder.decode(silkFile.getAbsolutePath(), pcmFile.getAbsolutePath());
        LameCoder.encode(pcmFile.getAbsolutePath(), mp3File.getAbsolutePath(), bitrate);
        pcmFile.delete();
        return mp3File;
    }

    public static File silkToMp3(File silkFile) throws IOException {
        return silkToMp3(silkFile, 24000);
    }

    static File getTempFile(File file, String type) {
        String name = file.getName();
        String fileName = name.substring(0, name.lastIndexOf(".")) + "." + type;
        return new File(file.getParent(), fileName);
    }
}
