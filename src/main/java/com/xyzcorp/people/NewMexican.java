package com.xyzcorp.people;

import java.util.Objects;

public class NewMexican extends American{
    private ChilePreference chilePreference;

    public ChilePreference getChilePreference() {
        return chilePreference;
    }

    public void setChilePreference(ChilePreference chilePreference) {
        this.chilePreference = chilePreference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewMexican)) return false;
        if (!super.equals(o)) return false;
        NewMexican that = (NewMexican) o;
        return chilePreference == that.chilePreference;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), chilePreference);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NewMexican{");
        sb.append("chilePreference=").append(chilePreference);
        sb.append('}');
        return sb.toString();
    }
}
