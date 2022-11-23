package fluffy.engine.library.collisions;

public class Collision{

    // RECTANGLE/RECTANGLE
    //ectRect(s1x,s1y,s1w,s1h, s2x,s2y,s2w,s2h);
    public static boolean AABB(BoxCollider col1, BoxCollider col2) {

        float r2x = col1.position.x;      // square position (move with mouse)
        float r2y = col1.position.y;
        float r2w = col1.size.x;     // and dimensions
        float r2h = col1.size.x;

        float r1x = col2.position.x;    // same for second square
        float r1y = col2.position.y;
        float r1w = col2.size.x;
        float r1h = col2.size.y;

        if (r1x + r1w >= r2x &&    // r1 right edge past r2 left
                r1x <= r2x + r2w &&    // r1 left edge past r2 right
                r1y + r1h >= r2y &&    // r1 top edge past r2 bottom
                r1y <= r2y + r2h) {    // r1 bottom edge past r2 top
            return true;
        }
        return false;
    }

    public static boolean PointInBox(float px, float py, BoxCollider b1){
        float rx = b1.position.x;
        float ry = b1.position.y;
        float rw = b1.size.x;
        float rh = b1.size.y;

        return  px >= rx &&
                py >= ry &&
                px <= rx + rw &&
                py <= ry + rh;
    }
}
