package eapli.base.Task.domain.Automatic;

import eapli.framework.domain.model.ValueObject;

import javax.persistence.Embeddable;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

@Embeddable
public class Script implements ValueObject, Comparable<Script> {

    private File script;


    public Script(final File script) {
        if (!script.exists()) {
            throw new IllegalArgumentException("File should exist!!");
        }
        this.script = script;
    }

    protected Script() {

    }

    public static Script valueOf(final File file) {
        return new Script(file);
    }


    public String contentOfScript() throws IOException {
        return Files.readString(Path.of(script.getPath()), StandardCharsets.UTF_8);
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Script)) return false;
        Script script1 = (Script) o;
        return Objects.equals(script, script1.script);
    }

    @Override
    public int hashCode() {
        return this.script.hashCode();
    }


    @Override
    public int compareTo(Script o) {
        return script.compareTo(o.script);
    }

    @Override
    public String toString() {
        return String.format("%s", script.getName());
    }

}
