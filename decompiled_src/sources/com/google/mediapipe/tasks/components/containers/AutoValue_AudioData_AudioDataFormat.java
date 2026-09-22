package com.google.mediapipe.tasks.components.containers;

/* JADX INFO: loaded from: C:\Users\abcsa\Downloads\Mouna\dex_temp\classes7.dex */
final class AutoValue_AudioData_AudioDataFormat extends AudioData.AudioDataFormat {
    private final int numOfChannels;
    private final float sampleRate;

    private AutoValue_AudioData_AudioDataFormat(int numOfChannels, float sampleRate) {
        this.numOfChannels = numOfChannels;
        this.sampleRate = sampleRate;
    }

    @Override // com.google.mediapipe.tasks.components.containers.AudioData.AudioDataFormat
    public int getNumOfChannels() {
        return this.numOfChannels;
    }

    @Override // com.google.mediapipe.tasks.components.containers.AudioData.AudioDataFormat
    public float getSampleRate() {
        return this.sampleRate;
    }

    public String toString() {
        return "AudioDataFormat{numOfChannels=" + this.numOfChannels + ", sampleRate=" + this.sampleRate + "}";
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o instanceof AudioData.AudioDataFormat) {
            AudioData.AudioDataFormat audioDataFormat = (AudioData.AudioDataFormat) o;
            if (this.numOfChannels == audioDataFormat.getNumOfChannels() && Float.floatToIntBits(this.sampleRate) == Float.floatToIntBits(audioDataFormat.getSampleRate())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return Float.floatToIntBits(this.sampleRate) ^ ((this.numOfChannels ^ 1000003) * 1000003);
    }

    static final class Builder extends AudioData.AudioDataFormat.Builder {
        private Integer numOfChannels;
        private Float sampleRate;

        Builder() {
        }

        @Override // com.google.mediapipe.tasks.components.containers.AudioData.AudioDataFormat.Builder
        public AudioData.AudioDataFormat.Builder setNumOfChannels(int numOfChannels) {
            this.numOfChannels = Integer.valueOf(numOfChannels);
            return this;
        }

        @Override // com.google.mediapipe.tasks.components.containers.AudioData.AudioDataFormat.Builder
        public AudioData.AudioDataFormat.Builder setSampleRate(float sampleRate) {
            this.sampleRate = Float.valueOf(sampleRate);
            return this;
        }

        @Override // com.google.mediapipe.tasks.components.containers.AudioData.AudioDataFormat.Builder
        AudioData.AudioDataFormat autoBuild() {
            String str;
            if (this.numOfChannels != null) {
                str = "";
            } else {
                str = " numOfChannels";
            }
            if (this.sampleRate == null) {
                str = str + " sampleRate";
            }
            if (!str.isEmpty()) {
                throw new IllegalStateException("Missing required properties:" + str);
            }
            return new AutoValue_AudioData_AudioDataFormat(this.numOfChannels.intValue(), this.sampleRate.floatValue());
        }
    }
}
