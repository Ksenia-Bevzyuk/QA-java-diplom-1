public class LimitDecPlaces {
    public static float limitDecPlaces(float value, int places) {

        long deg = (long) Math.pow(10, places);
        value = value * deg;
        long limit = Math.round(value);
        return (float) limit / deg;
    }
}
