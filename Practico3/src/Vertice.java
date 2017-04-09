public class Vertice {

    private boolean isVisited;
    private boolean isFinished;
    private Object value;

    public Vertice(Object value) {
        isVisited = false;
        isFinished = false;
        this.value = value;
    }

    public String toString() {
        return value.toString();
    }

    public void setVisited(boolean visited) {
        isVisited = visited;
    }

    public boolean isVisited() {
        return isVisited;
    }

    public Object getValue() {
        return value;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Vertice) {
            Vertice v = (Vertice) obj;
            return value.equals(v.getValue());
        }
        return value.equals(obj);
    }
}