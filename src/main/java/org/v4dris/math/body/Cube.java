package org.v4dris.math.body;

import org.v4dris.math.point.Point3D;
import org.v4dris.math.vector.Vector3D;

public class Cube extends Body3D{
    private double size;

    public Cube(double size) {
        super(null);
        this.size = size;
        double zr = -size/2;
        Point3D a = new Point3D(zr,zr,zr);
        Point3D b = new Point3D(size/2,zr,zr);
        Point3D c = new Point3D(size/2,size/2,zr);
        Point3D d = new Point3D(zr,size/2,zr);

        Point3D e = new Point3D(zr,zr,size/2);
        Point3D f = new Point3D(size/2,zr,size/2);
        Point3D g = new Point3D(size/2,size/2,size/2);
        Point3D h = new Point3D(zr, size/2, size/2);

        this.vectors = new Vector3D[]{
                new Vector3D(a, b),
                new Vector3D(b ,c),
                new Vector3D(c, d),
                new Vector3D(d, a),

                new Vector3D(e, f),
                new Vector3D(f, g),
                new Vector3D(g, h),
                new Vector3D(h, e),

                new Vector3D(a, e),
                new Vector3D(b, f),
                new Vector3D(c, g),
                new Vector3D(h, d)
        };
    }
}
