package org.v4dris.math.body;

import org.v4dris.math.matrix.Matrix;
import org.v4dris.math.vector.Vector3D;

public class Body3D {
    public Vector3D[] vectors;

    public Body3D(Vector3D[] vectors){
        this.vectors = vectors;
    }

    public void transform(Matrix matrix) throws Exception {
        for(int i = 0; i < vectors.length; i++){
            vectors[i].rotate(matrix);
        }
    }
}
