package com.heyzap.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LargeSet<T> {
    private Set<T> backingSet;
    private boolean whitelist;

    public LargeSet(Collection<T> from) {
        this.backingSet = new HashSet();
        this.whitelist = true;
        this.whitelist = true;
        this.backingSet.addAll(from);
    }

    public LargeSet(Collection<T> from, boolean whitelist) {
        this.backingSet = new HashSet();
        this.whitelist = true;
        this.whitelist = whitelist;
        this.backingSet.addAll(from);
    }

    public LargeSet(LargeSet<T> from) {
        this.backingSet = new HashSet();
        this.whitelist = true;
        this.backingSet = new HashSet(from.getBackingSet());
        this.whitelist = from.isWhitelist();
    }

    public LargeSet() {
        this.backingSet = new HashSet();
        this.whitelist = true;
    }

    public boolean add(T object) {
        if (this.whitelist) {
            return this.backingSet.add(object);
        }
        return this.backingSet.remove(object);
    }

    public boolean addAll(Collection collection) {
        if (collection instanceof LargeSet) {
            LargeSet other = (LargeSet) collection;
            if (this.whitelist) {
                if (other.isWhitelist()) {
                    return this.backingSet.addAll(other.getBackingSet());
                }
                Set<T> tmpBack = new HashSet(other.getBackingSet());
                tmpBack.removeAll(this.backingSet);
                int oldSize = size();
                this.whitelist = false;
                this.backingSet = tmpBack;
                if (oldSize != size()) {
                    return true;
                }
                return false;
            } else if (other.isWhitelist()) {
                return this.backingSet.removeAll(other.getBackingSet());
            } else {
                return this.backingSet.retainAll(other.getBackingSet());
            }
        } else if (this.whitelist) {
            return this.backingSet.addAll(collection);
        } else {
            return this.backingSet.removeAll(collection);
        }
    }

    public boolean addAll() {
        int oldSize = size();
        this.whitelist = false;
        this.backingSet.clear();
        if (size() != oldSize) {
            return true;
        }
        return false;
    }

    public void clear() {
        this.backingSet.clear();
        this.whitelist = true;
    }

    public boolean contains(Object object) {
        return (!this.whitelist ? 1 : 0) ^ this.backingSet.contains(object);
    }

    public boolean isEmpty() {
        return this.whitelist && this.backingSet.isEmpty();
    }

    public Iterator iterator() {
        if (this.whitelist) {
            return this.backingSet.iterator();
        }
        throw new UnsupportedOperationException();
    }

    public boolean remove(Object object) {
        if (this.whitelist) {
            return this.backingSet.remove(object);
        }
        return this.backingSet.add(object);
    }

    public int size() {
        return this.whitelist ? this.backingSet.size() : -1 - this.backingSet.size();
    }

    public Object[] toArray() {
        if (this.whitelist) {
            return this.backingSet.toArray();
        }
        throw new UnsupportedOperationException();
    }

    public T[] toArray(Object[] array) {
        if (this.whitelist) {
            return this.backingSet.toArray(array);
        }
        throw new UnsupportedOperationException();
    }

    public Set<T> intersect(Set<T> domain) {
        HashSet<T> intersection = new HashSet();
        for (T el : domain) {
            if (contains(el)) {
                intersection.add(el);
            }
        }
        return intersection;
    }

    public boolean retainAll(Collection collection) {
        int oldSize;
        if (collection instanceof LargeSet) {
            LargeSet other = (LargeSet) collection;
            if (other.isWhitelist()) {
                Set<T> tmpBacking = new HashSet(other.getBackingSet());
                if (this.whitelist) {
                    tmpBacking.retainAll(this.backingSet);
                } else {
                    tmpBacking.removeAll(this.backingSet);
                }
                this.whitelist = true;
                oldSize = size();
                this.backingSet = tmpBacking;
                if (size() != oldSize) {
                    return true;
                }
                return false;
            } else if (this.whitelist) {
                return this.backingSet.removeAll(other.getBackingSet());
            } else {
                return this.backingSet.addAll(other.getBackingSet());
            }
        }
        Set<T> kept = new HashSet();
        for (Object o : collection) {
            if (contains(o)) {
                kept.add(o);
            }
        }
        this.whitelist = true;
        oldSize = size();
        this.backingSet = kept;
        if (size() == oldSize) {
            return false;
        }
        return true;
    }

    public boolean removeAll(Collection collection) {
        if (collection instanceof LargeSet) {
            LargeSet other = (LargeSet) collection;
            if (this.whitelist) {
                if (other.isWhitelist()) {
                    return this.backingSet.removeAll(other.getBackingSet());
                }
                return this.backingSet.addAll(other.getBackingSet());
            } else if (other.isWhitelist()) {
                return this.backingSet.addAll(other.getBackingSet());
            } else {
                return this.backingSet.removeAll(other.getBackingSet());
            }
        } else if (this.whitelist) {
            return this.backingSet.removeAll(collection);
        } else {
            return this.backingSet.addAll(collection);
        }
    }

    public boolean containsAll(Collection collection) {
        if (collection instanceof LargeSet) {
            LargeSet other = (LargeSet) collection;
            if (this.whitelist) {
                if (other.isWhitelist()) {
                    return this.backingSet.containsAll(other.getBackingSet());
                }
                return false;
            } else if (!other.isWhitelist()) {
                return other.getBackingSet().containsAll(this.backingSet);
            } else {
                for (Object o : other.getBackingSet()) {
                    if (this.backingSet.contains(o)) {
                        return false;
                    }
                }
                return true;
            }
        } else if (this.whitelist) {
            return this.backingSet.containsAll(collection);
        } else {
            for (Object o2 : collection) {
                if (this.backingSet.contains(o2)) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LargeSet<?> largeSet = (LargeSet) o;
        if (this.whitelist != largeSet.whitelist) {
            return false;
        }
        if (this.backingSet != null) {
            if (this.backingSet.equals(largeSet.backingSet)) {
                return true;
            }
        } else if (largeSet.backingSet == null) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result;
        int i = 0;
        if (this.backingSet != null) {
            result = this.backingSet.hashCode();
        } else {
            result = 0;
        }
        int i2 = result * 31;
        if (this.whitelist) {
            i = 1;
        }
        return i2 + i;
    }

    public String toString() {
        return "LargeSet{backingSet=" + this.backingSet + ", whitelist=" + this.whitelist + '}';
    }

    public Set<T> getBackingSet() {
        return this.backingSet;
    }

    public boolean isWhitelist() {
        return this.whitelist;
    }

    public static <T> LargeSet<T> ofEverything() {
        LargeSet<T> largeSet = new LargeSet();
        largeSet.addAll();
        return largeSet;
    }

    public static <T> LargeSet<T> of(T... values) {
        return new LargeSet(Arrays.asList(values));
    }

    public static <T> LargeSet<T> ofNot(T... values) {
        return new LargeSet(Arrays.asList(values), false);
    }

    public static <T> LargeSet<T> ofNotCollection(Collection<T> values) {
        return new LargeSet(values, false);
    }
}
