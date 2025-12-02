package combinatorics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import model.Face;

/**
 * @author kart
 *
 */
public class PermutationDepot_Serna
{
	private PermutationDepot_Serna()
	{
		throw new RuntimeException("DO NOT INSTANTIATE!");
	}
	
	//part of post: rv.size() == 24
	public static Set<Permutation_Kart<Face>> getRotationsOfTheCube()
	{
	    Set<Permutation_Kart<Face>> rotations = new HashSet<>();
	    
	    // making myself new names for the Face enums so it's less typing
	    final Face T = Face.TOP;
	    final Face L = Face.LEFT;
	    final Face F = Face.FRONT;
	    final Face R = Face.RIGHT;
	    final Face B = Face.BOTTOM;
	    final Face K = Face.BACK;
	 
// VERTEX TO VERTEX ROTATIONS (8 total)
	    
	    // Axis 1: through (T, F, R) vertex - 120 deg
	    Set<List<Face>> vert_axis1_120_cycleSet = new HashSet<>();
	    vert_axis1_120_cycleSet.add(cycle(T, F, R));
	    vert_axis1_120_cycleSet.add(cycle(B, K, L));
	    Permutation_Kart<Face> vert_axis1_120_permutation = new PermutationImpl_Serna<>(vert_axis1_120_cycleSet);
	    rotations.add(vert_axis1_120_permutation);
	    
	    // Axis 1: through (T, F, R) vertex - 240 deg
	    Set<List<Face>> vert_axis1_240_cycleSet = new HashSet<>();
	    vert_axis1_240_cycleSet.add(cycle(T, R, F));
	    vert_axis1_240_cycleSet.add(cycle(B, L, K));
	    Permutation_Kart<Face> vert_axis1_240_permutation = new PermutationImpl_Serna<>(vert_axis1_240_cycleSet);
	    rotations.add(vert_axis1_240_permutation);
	    
	    // Axis 2: through (T, R, K) vertex - 120 deg
	    Set<List<Face>> vert_axis2_120_cycleSet = new HashSet<>();
	    vert_axis2_120_cycleSet.add(cycle(T, R, K));
	    vert_axis2_120_cycleSet.add(cycle(B, L, F));
	    Permutation_Kart<Face> vert_axis2_120_permutation = new PermutationImpl_Serna<>(vert_axis2_120_cycleSet);
	    rotations.add(vert_axis2_120_permutation);
	    
	    // Axis 2: through (T, R, K) vertex - 240 deg
	    Set<List<Face>> vert_axis2_240_cycleSet = new HashSet<>();
	    vert_axis2_240_cycleSet.add(cycle(T, K, R));
	    vert_axis2_240_cycleSet.add(cycle(B, F, L));
	    Permutation_Kart<Face> vert_axis2_240_permutation = new PermutationImpl_Serna<>(vert_axis2_240_cycleSet);
	    rotations.add(vert_axis2_240_permutation);
	    
	    // Axis 3: through (T, K, L) vertex - 120 deg
	    Set<List<Face>> vert_axis3_120_cycleSet = new HashSet<>();
	    vert_axis3_120_cycleSet.add(cycle(T, K, L));
	    vert_axis3_120_cycleSet.add(cycle(B, F, R));
	    Permutation_Kart<Face> vert_axis3_120_permutation = new PermutationImpl_Serna<>(vert_axis3_120_cycleSet);
	    rotations.add(vert_axis3_120_permutation);
	    
	    // Axis 3: through (T, K, L) vertex - 240 deg
	    Set<List<Face>> vert_axis3_240_cycleSet = new HashSet<>();
	    vert_axis3_240_cycleSet.add(cycle(T, L, K));
	    vert_axis3_240_cycleSet.add(cycle(B, R, F));
	    Permutation_Kart<Face> vert_axis3_240_permutation = new PermutationImpl_Serna<>(vert_axis3_240_cycleSet);
	    rotations.add(vert_axis3_240_permutation);
	    
	    // Axis 4: through (T, L, F) vertex - 120 deg
	    Set<List<Face>> vert_axis4_120_cycleSet = new HashSet<>();
	    vert_axis4_120_cycleSet.add(cycle(T, L, F));
	    vert_axis4_120_cycleSet.add(cycle(B, R, K));
	    Permutation_Kart<Face> vert_axis4_120_permutation = new PermutationImpl_Serna<>(vert_axis4_120_cycleSet);
	    rotations.add(vert_axis4_120_permutation);
	    
	    // Axis 4: through (T, L, F) vertex - 240 deg
	    Set<List<Face>> vert_axis4_240_cycleSet = new HashSet<>();
	    vert_axis4_240_cycleSet.add(cycle(T, F, L));
	    vert_axis4_240_cycleSet.add(cycle(B, K, R));
	    Permutation_Kart<Face> vert_axis4_240_permutation = new PermutationImpl_Serna<>(vert_axis4_240_cycleSet);
	    rotations.add(vert_axis4_240_permutation);
	    
// EDGE TO EDGE ROTATIONS (6 total)
	    
	    // backslash Intersection - 180 deg
	    Set<List<Face>> edge_backslash_cycleSet = new HashSet<>();
	    edge_backslash_cycleSet.add(cycle(T, F));
	    edge_backslash_cycleSet.add(cycle(B, K));
	    edge_backslash_cycleSet.add(cycle(L, R));
	    Permutation_Kart<Face> edge_backslash_permutation = new PermutationImpl_Serna<>(edge_backslash_cycleSet);
	    rotations.add(edge_backslash_permutation);
	    
	    // forward-slash Intersection - 180 deg
	    Set<List<Face>> edge_forwardslash_cycleSet = new HashSet<>();
	    edge_forwardslash_cycleSet.add(cycle(T, R));
	    edge_forwardslash_cycleSet.add(cycle(B, L));
	    edge_forwardslash_cycleSet.add(cycle(F, K));
	    Permutation_Kart<Face> edge_forwardslash_permutation = new PermutationImpl_Serna<>(edge_forwardslash_cycleSet);
	    rotations.add(edge_forwardslash_permutation);
	    
	    // slide Intersection - 180 deg
	    Set<List<Face>> edge_slide_cycleSet = new HashSet<>();
	    edge_slide_cycleSet.add(cycle(T, K));
	    edge_slide_cycleSet.add(cycle(B, F));
	    edge_slide_cycleSet.add(cycle(L, R));
	    Permutation_Kart<Face> edge_slide_permutation = new PermutationImpl_Serna<>(edge_slide_cycleSet);
	    rotations.add(edge_slide_permutation);
	    
	    // hill Intersection - 180 deg
	    Set<List<Face>> edge_hill_cycleSet = new HashSet<>();
	    edge_hill_cycleSet.add(cycle(T, L));
	    edge_hill_cycleSet.add(cycle(B, R));
	    edge_hill_cycleSet.add(cycle(F, K));
	    Permutation_Kart<Face> edge_hill_permutation = new PermutationImpl_Serna<>(edge_hill_cycleSet);
	    rotations.add(edge_hill_permutation);
	    
	    // wall Pointing Right Intersection - 180 deg
	    Set<List<Face>> edge_wallright_cycleSet = new HashSet<>();
	    edge_wallright_cycleSet.add(cycle(F, R));
	    edge_wallright_cycleSet.add(cycle(K, L));
	    edge_wallright_cycleSet.add(cycle(T, B));
	    Permutation_Kart<Face> edge_wallright_permutation = new PermutationImpl_Serna<>(edge_wallright_cycleSet);
	    rotations.add(edge_wallright_permutation);
	    
	    // wall Pointing Left Intersection - 180 deg
	    Set<List<Face>> edge_wallleft_cycleSet = new HashSet<>();
	    edge_wallleft_cycleSet.add(cycle(F, L));
	    edge_wallleft_cycleSet.add(cycle(K, R));
	    edge_wallleft_cycleSet.add(cycle(T, B));
	    Permutation_Kart<Face> edge_wallleft_permutation = new PermutationImpl_Serna<>(edge_wallleft_cycleSet);
	    rotations.add(edge_wallleft_permutation);
	    
// FACE TO FACE ROTATIONS (9 total)
	    
	    // Axis TOP-BOTTOM: 90 deg
	    Set<List<Face>> face_tb_90_cycleSet = new HashSet<>();
	    face_tb_90_cycleSet.add(cycle(F, R, K, L));
	    Permutation_Kart<Face> face_tb_90_permutation = new PermutationImpl_Serna<>(face_tb_90_cycleSet);
	    rotations.add(face_tb_90_permutation);
	    
	    // Axis TOP-BOTTOM: 180 deg
	    Set<List<Face>> face_tb_180_cycleSet = new HashSet<>();
	    face_tb_180_cycleSet.add(cycle(F, K));
	    face_tb_180_cycleSet.add(cycle(L, R));
	    Permutation_Kart<Face> face_tb_180_permutation = new PermutationImpl_Serna<>(face_tb_180_cycleSet);
	    rotations.add(face_tb_180_permutation);
	    
	    // Axis TOP-BOTTOM: 270 deg
	    Set<List<Face>> face_tb_270_cycleSet = new HashSet<>();
	    face_tb_270_cycleSet.add(cycle(F, L, K, R));
	    Permutation_Kart<Face> face_tb_270_permutation = new PermutationImpl_Serna<>(face_tb_270_cycleSet);
	    rotations.add(face_tb_270_permutation);
	    
	    // Axis FRONT-BACK: 90 deg
	    Set<List<Face>> face_fk_90_cycleSet = new HashSet<>();
	    face_fk_90_cycleSet.add(cycle(T, R, B, L));
	    Permutation_Kart<Face> face_fk_90_permutation = new PermutationImpl_Serna<>(face_fk_90_cycleSet);
	    rotations.add(face_fk_90_permutation);
	    
	    // Axis FRONT-BACK: 180 deg
	    Set<List<Face>> face_fk_180_cycleSet = new HashSet<>();
	    face_fk_180_cycleSet.add(cycle(T, B));
	    face_fk_180_cycleSet.add(cycle(R, L));
	    Permutation_Kart<Face> face_fk_180_permutation = new PermutationImpl_Serna<>(face_fk_180_cycleSet);
	    rotations.add(face_fk_180_permutation);
	    
	    // Axis FRONT-BACK: 270 deg
	    Set<List<Face>> face_fk_270_cycleSet = new HashSet<>();
	    face_fk_270_cycleSet.add(cycle(T, L, B, R));
	    Permutation_Kart<Face> face_fk_270_permutation = new PermutationImpl_Serna<>(face_fk_270_cycleSet);
	    rotations.add(face_fk_270_permutation);
	    
	    // Axis LEFT-RIGHT: 90 deg
	    Set<List<Face>> face_lr_90_cycleSet = new HashSet<>();
	    face_lr_90_cycleSet.add(cycle(T, F, B, K));
	    Permutation_Kart<Face> face_lr_90_permutation = new PermutationImpl_Serna<>(face_lr_90_cycleSet);
	    rotations.add(face_lr_90_permutation);
	    
	    // Axis LEFT-RIGHT: 180 deg
	    Set<List<Face>> face_lr_180_cycleSet = new HashSet<>();
	    face_lr_180_cycleSet.add(cycle(T, B));
	    face_lr_180_cycleSet.add(cycle(F, K));
	    Permutation_Kart<Face> face_lr_180_permutation = new PermutationImpl_Serna<>(face_lr_180_cycleSet);
	    rotations.add(face_lr_180_permutation);
	    
	    // Axis LEFT-RIGHT: 270 deg
	    Set<List<Face>> face_lr_270_cycleSet = new HashSet<>();
	    face_lr_270_cycleSet.add(cycle(T, K, B, F));
	    Permutation_Kart<Face> face_lr_270_permutation = new PermutationImpl_Serna<>(face_lr_270_cycleSet);
	    rotations.add(face_lr_270_permutation);
	    
// IDENTITY ROTATION
	    Set<List<Face>> identity_cycleSet = new HashSet<>(); // Empty cycle set creates identity permutation
	    Permutation_Kart<Face> identity_permutation = new PermutationImpl_Serna<>(identity_cycleSet);
	    rotations.add(identity_permutation);
	    
	    // Post-condition check
	    assert rotations.size() == 24 : "Post-condition violated: there must be 24 rotations of a cube";
	    
	    return rotations;
	}
	
	private static List<Face> cycle(Face... faces) //using the ... to allow for any amount of faces to be returned as a list of
	{
		return List.of(faces);
	}
}