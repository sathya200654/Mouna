package com.google.mediapipe.tasks.components.utils;

import com.google.mediapipe.tasks.components.containers.Embedding;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
public class CosineSimilarity {
    private CosineSimilarity() {
    }

    public static double compute(Embedding u, Embedding v) {
        if (u.floatEmbedding().length > 0 && v.floatEmbedding().length > 0) {
            return computeFloat(u.floatEmbedding(), v.floatEmbedding());
        }
        if (u.quantizedEmbedding().length > 0 && v.quantizedEmbedding().length > 0) {
            return computeQuantized(u.quantizedEmbedding(), v.quantizedEmbedding());
        }
        throw new IllegalArgumentException("Cannot compute cosine similarity between quantized and float embeddings.");
    }

    private static double computeFloat(float[] u, float[] v) {
        if (u.length != v.length) {
            throw new IllegalArgumentException(String.format("Cannot compute cosine similarity between embeddings of different sizes (%d vs. %d).", Integer.valueOf(u.length), Integer.valueOf(v.length)));
        }
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 0; i < u.length; i++) {
            float f = u[i];
            float f2 = v[i];
            d2 += (double) (f * f2);
            d += (double) (f * f);
            d3 += (double) (f2 * f2);
        }
        if (d <= 0.0d || d3 <= 0.0d) {
            throw new IllegalArgumentException("Cannot compute cosine similarity on embedding with 0 norm.");
        }
        return d2 / Math.sqrt(d * d3);
    }

    private static double computeQuantized(byte[] u, byte[] v) {
        if (u.length != v.length) {
            throw new IllegalArgumentException(String.format("Cannot compute cosine similarity between embeddings of different sizes (%d vs. %d).", Integer.valueOf(u.length), Integer.valueOf(v.length)));
        }
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        for (int i = 0; i < u.length; i++) {
            byte b = u[i];
            byte b2 = v[i];
            d2 += (double) (b * b2);
            d += (double) (b * b);
            d3 += (double) (b2 * b2);
        }
        if (d <= 0.0d || d3 <= 0.0d) {
            throw new IllegalArgumentException("Cannot compute cosine similarity on embedding with 0 norm.");
        }
        return d2 / Math.sqrt(d * d3);
    }
}
