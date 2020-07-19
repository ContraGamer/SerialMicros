/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java3D;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.universe.SimpleUniverse;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;

/**
 *
 * @author Contr
 */
public class Main {

    SimpleUniverse universo = new SimpleUniverse();
    BranchGroup grupo = new BranchGroup();
    ColorCube cubo = new ColorCube(0.3);
    TransformGroup GT = new TransformGroup();
    Transform3D transformar = new Transform3D();

    public Main() {
        GT.setTransform(transformar);
        GT.addChild(cubo);
        grupo.addChild(GT);
        universo.getViewingPlatform().setNominalViewingTransform();
        universo.addBranchGraph(grupo);
    }

    public static void main(String[] args) {
        new Main();
    }

}
