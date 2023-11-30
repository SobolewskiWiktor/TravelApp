public enum TravelStatus {
    COMPLETED {
        @Override
        public String getStatus() {
            return "Completed";
        }
    },
    IN_PROGRESS {
        @Override
        public String getStatus() {
            return "In Progress";
        }
    },
    NOT_STARTED {
        @Override
        public String getStatus() {
            return "Not Started";
        }
    };

    public abstract String getStatus();
}