package org.v4dris.math.body;

import org.v4dris.math.point.Point3D;
import org.v4dris.math.vector.Vector3D;

public class Cube extends Body3D{

    public Cube(double size) {
        super(null);
        Point3D a = new Point3D(0,0,0);
        Point3D b = new Point3D(size,0,0);
        Point3D c = new Point3D(size,size,0);
        Point3D d = new Point3D(0,size,0);

        Point3D e = new Point3D(0,0,size);
        Point3D f = new Point3D(size,0,size);
        Point3D g = new Point3D(size,size,size);
        Point3D h = new Point3D(0, size, size);

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
