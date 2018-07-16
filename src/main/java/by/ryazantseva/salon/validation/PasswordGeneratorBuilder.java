package by.ryazantseva.salon.validation;

public class PasswordGeneratorBuilder {
    private boolean useLower;
    private boolean useUpper;
    private boolean useDigits;

    public PasswordGeneratorBuilder() {
        this.useLower = false;
        this.useUpper = false;
        this.useDigits = false;
    }

    public PasswordGeneratorBuilder useLower(boolean useLower) {
        this.useLower = useLower;
        return this;
    }

    public PasswordGeneratorBuilder useUpper(boolean useUpper) {
        this.useUpper = useUpper;
        return this;
    }

    public PasswordGeneratorBuilder useDigits(boolean useDigits) {
        this.useDigits = useDigits;
        return this;
    }

    public boolean isUseLower() {
        return useLower;
    }

    public boolean isUseUpper() {
        return useUpper;
    }

    public boolean isUseDigits() {
        return useDigits;
    }
    public PasswordGenerator build() {
        return new PasswordGenerator(this);
    }
}
