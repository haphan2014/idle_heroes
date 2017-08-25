package com.applovin.impl.sdk;

public class cf implements Comparable {
    private static int f588a = 0;
    private final int f589b;
    private final String f590c;
    private final Object f591d;

    private cf(String str, Object obj) {
        if (str == null) {
            throw new IllegalArgumentException("No name specified");
        } else if (obj == null) {
            throw new IllegalArgumentException("No default value specified");
        } else {
            this.f590c = str;
            this.f591d = obj;
            this.f589b = f588a;
            f588a++;
        }
    }

    public int m493a() {
        return this.f589b;
    }

    Object m494a(Object obj) {
        return this.f591d.getClass().cast(obj);
    }

    public String m495b() {
        return this.f590c;
    }

    public Object m496c() {
        return this.f591d;
    }

    public int compareTo(Object obj) {
        return (obj == null || !(obj instanceof cf)) ? 0 : this.f590c.compareTo(((cf) obj).m495b());
    }
}
