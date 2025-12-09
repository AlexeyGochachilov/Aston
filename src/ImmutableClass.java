public final class ImmutableClass {

    private final Mutable mutable;

    public ImmutableClass(Mutable mutableForConstructor) {
        this.mutable = new Mutable();
        copyFieldOfMutable(mutableForConstructor, mutable);
    }
    public Mutable getMutable() {
        Mutable copy = new Mutable();
        copyFieldOfMutable(mutable, copy);
        return copy;
    }
    private static void copyFieldOfMutable(Mutable from, Mutable destination) {
        destination.name = from.name;
        destination.weight = from.weight;
    }
}
class Mutable {

    String name;
    int weight;
}
