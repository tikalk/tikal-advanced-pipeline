class settings implements Serializable {
    private String flow
    def setName(value) {
        flow = value
    }
    def getName() {
        flow
    }
}