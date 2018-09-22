package com.thecodeslinger.javaexercise.io;

import java.io.IOException;
import java.io.InputStream;

class NonClosingInputStreamWrapper extends InputStream {
    private InputStream wrappedStream;
    
    public NonClosingInputStreamWrapper(InputStream wrappedStream) {
        this.wrappedStream = wrappedStream;
    }
    
    @Override
    public int available() throws IOException {
        return wrappedStream.available();
    }
    
    @Override
    public void close() {
        // Not forwarded. This is a non-closing wrapper.
    }
    
    @Override
    public void mark(int readLimit) {
        wrappedStream.mark(readLimit);
    }
    
    @Override
    public boolean markSupported() {
        return wrappedStream.markSupported();
    }

    @Override
    public int read() throws IOException {
        return wrappedStream.read();
    }
    
    @Override
    public int read(byte[] b) throws IOException {
        return wrappedStream.read(b);
    }
    
    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return wrappedStream.read(b, off, len);
    }
    
    @Override
    public void reset() throws IOException {
        wrappedStream.reset();
    }
    
    @Override
    public long skip(long n) throws IOException {
        return wrappedStream.skip(n);
    }
}