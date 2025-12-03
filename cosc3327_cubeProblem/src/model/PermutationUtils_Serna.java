package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermutationUtils_Serna {
	
	public static <E> List<E> getCycle(Permutation<E> permutation, E e) {
		/**
	     * Given a permutation and a starting element e, return the full cycle containing e.
	     *
	     * part of pre: permutation != null; permutation.getDomain().contains(e)
	     * part of post: rv is the list of elements in the cycle containing e, in order,
	     *               starting with e and following permutation.getImage until cycle closes.
	     */
		
		//assert preconditions
		assert permutation != null;
		assert permutation.getDomain().contains(e);
		
		//setup local variables
		List<E> theCycle = new ArrayList<>();
		
		//mark starting element as the one passed in
	    E current = e;
	    do {
	        theCycle.add(current);
	        //get the next one
	        current = permutation.getImage(current);
	    } while (!current.equals(e));

	    return theCycle;
    }

    public static <E> Permutation<E> getInverse(Permutation<E> permutation) {
    	/**
         * Return a new permutation that is the inverse of the given permutation.
         *
         * part of pre: permutation != null
         * part of post: for all e in permutation.getDomain(),
         *               rv.getImage(permutation.getImage(e)) == e
         */
    	
    	//assert preconditions
    	assert permutation != null;
    	
    	//local var setup
    	PermutationImpl_Serna inversePermutation;
        Set<List<E>> newCycles = new HashSet<>();
        Set<E> visited = new HashSet<>();
    	
        //traverse the permutation
        for (E e : permutation.getDomain()) {
            if (!visited.contains(e)) {
                // build one cycle of the inverse
                List<E> cycle = new ArrayList<>();
                E current = e;
                do {
                    cycle.add(current);
                    visited.add(current);
                    current = permutation.getPreImage(current); // going through its preimages
                } while (!current.equals(e));

                newCycles.add(cycle);
            }
        }
        
        inversePermutation = new PermutationImpl_Serna(newCycles);
    	
    	return inversePermutation;
	}

    public static <E> Permutation<E> compose(Permutation<E> permutation1, Permutation<E> permutation2) {
    	/**
         * Compose two permutations: permutation1 ∘ permutation2.
         * That is, (permutation1 after permutation2): for all e,
         * rv.getImage(e) = permutation1.getImage(permutation2.getImage(e)).
         *
         * part of pre: permutation1 != null; permutation2 != null;
         *              permutation1.getDomain().containsAll(permutation2.getDomain())
         * part of post: rv is the composition permutation1 ∘ permutation2
         */
    	
    	//assert preconditions (non-null, domain containment)
    	assert permutation1 != null;
    	assert permutation2 != null;
        assert permutation1.getDomain().containsAll(permutation2.getDomain());
    	
        //initialize variables
        Set<List<E>> newCycles = new HashSet<>();
        Set<E> visited = new HashSet<>();

        //get the composed images, using p1(p2(e))
        Map<E, E> composedMap = new HashMap<>();
        for (E e : permutation2.getDomain()) {
            E image = permutation1.getImage(permutation2.getImage(e));
            composedMap.put(e, image);
        }
        
        //build the cycles using those images
        for (E e : permutation2.getDomain()) {
            if (!visited.contains(e)) {
                List<E> cycle = new ArrayList<>();
                E current = e;
                do {
                    cycle.add(current);
                    visited.add(current);
                    current = composedMap.get(current);
                } while (current != null && !current.equals(e));
                newCycles.add(cycle);
            }
        }

        // build a PermutationImpl_Serna from these cycles
        return new PermutationImpl_Serna<>(newCycles);  
    }

    public static <E> boolean isCyclic(Permutation<E> permutation) {
    	/**
         * Determine if the given permutation consists of a single cycle (i.e., is cyclic).
         *
         * part of pre: permutation != null
         * part of post: rv == true if permutation consists of exactly one cycle spanning entire domain
         */
    	
    	assert permutation != null;
    	
    	//local var setup
    	boolean decision = true;
    	
    	// domain check
        Set<E> domain = permutation.getDomain();
        if (domain.isEmpty()) return false; // an empty permutation is not cyclic

    	// pick any starting element
        E start = domain.iterator().next();

        // get the cycle containing that element
        List<E> cycle = getCycle(permutation, start);

        // if the cycle covers the whole domain, it's cyclic
        decision = cycle.size() == domain.size();
        
        return decision;
    }
    
    public static <E> Set<E> findDomainFromCycles(Set<List<E>> cycles) {
        Set<E> theDomain = new HashSet<>();
    	
    	//filling in the domain set with unique values
        for (List<E> cycle : cycles) {
            for (E element : cycle) {
                theDomain.add(element);
            }
        }
    	
		return theDomain;
    }

}
