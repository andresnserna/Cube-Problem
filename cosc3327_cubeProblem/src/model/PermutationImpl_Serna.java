package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermutationImpl_Serna<E> implements Permutation<E> {
	private final Map<E,E> imageMap;
    private final Map<E,E> preImageMap;
    private final Set<E> domain;
	

	public PermutationImpl_Serna(Set<List<E>> cycles, Set<E> domain) {
		// 0. null and empty check
		// Assert that cycles set does not contain null
		assert !cycles.contains(null) 
		    : "Cycles set cannot contain null";

		// Assert that no cycle is empty
		for (List<E> cycle : cycles) {
		    assert cycle != null && !cycle.isEmpty() 
		        : "No cycle can be empty";
		}
		
		// 1. Assert that every element of every cycle is in the domain:
	    for (List<E> cycle : cycles) {
	        for (E element : cycle) {
	            assert domain.contains(element) 
	                : "Domain must contain element " + element;
	        }
	    }

	    // 2. Assert that no element appears in more than one cycle:
	    Set<E> seen = new HashSet<>();
	    for (List<E> cycle : cycles) {
	        for (E element : cycle) {
	            assert seen.add(element)
	                : "Element appears in more than one cycle: " + element;
	        }
	    }
		
		
		//variable set up
		this.domain = domain;
        this.imageMap = new HashMap<>();
        this.preImageMap = new HashMap<>();
        
        //filling the image map
        for (List<E> cycle : cycles) {
            int size = cycle.size(); //setting size variable
            
            // walk through each element in the cycle
            for (int i = 0; i < size; i++) {
                E current = cycle.get(i);
                E next = cycle.get((i + 1) % size); // wraps around to first element

                // populate image and preimage
                imageMap.put(current, next);
                preImageMap.put(next, current);
            }
        }

        //address the single cycles
        for (E e : this.domain) {
            if (!imageMap.containsKey(e)) {
                imageMap.put(e, e);      // maps to itself
                preImageMap.put(e, e);   // preimage is itself
            }
        }
        
	}
	
	public PermutationImpl_Serna(Set<List<E>> cycles) {
		// 0. null and empty check
		// Assert that cycles set does not contain null
		assert !cycles.contains(null) 
		    : "Cycles set cannot contain null";

		// Assert that no cycle is empty
		for (List<E> cycle : cycles) {
		    assert cycle != null && !cycle.isEmpty() 
		        : "No cycle can be empty";
		}
		
		// 1. Assert that every element of every cycle is in the domain:
	    for (List<E> cycle : cycles) {
	        for (E element : cycle) {
	            assert PermutationUtils_Serna.findDomainFromCycles(cycles).contains(element) 
	                : "Domain must contain element " + element;
	        }
	    }

	    // 2. Assert that no element appears in more than one cycle:
	    Set<E> seen = new HashSet<>();
	    for (List<E> cycle : cycles) {
	        for (E element : cycle) {
	            assert seen.add(element)
	                : "Element appears in more than one cycle: " + element;
	        }
	    }
		
		//variable set-up
		this.domain = PermutationUtils_Serna.findDomainFromCycles(cycles);
        this.imageMap = new HashMap<>();
        this.preImageMap = new HashMap<>();
        
        //filling the image map
        for (List<E> cycle : cycles) {
            int size = cycle.size(); //setting size variable
            
            // walk through each element in the cycle
            for (int i = 0; i < size; i++) {
                E current = cycle.get(i);
                E next = cycle.get((i + 1) % size); // wraps around to first element

                // populate image and preimage
                imageMap.put(current, next);
                preImageMap.put(next, current);
            }
        }

        //address the single cycles
        for (E e : this.domain) {
            if (!imageMap.containsKey(e)) {
                imageMap.put(e, e);      // maps to itself
                preImageMap.put(e, e);   // preimage is itself
            }
        }
	}

	@Override
	public E getImage(E e) {
//		Pre: domain.contains(e)
//		Post: Returns the element that 'e' maps to under this permutation.
		assert domain.contains(e);
	    return imageMap.get(e);
	}

	@Override
	public E getPreImage(E e) {
//		Pre: domain.contains(e)
//		Post: Returns the element that maps to 'e'
		assert domain.contains(e);
	    return preImageMap.get(e);
	}

	@Override
	public Set<E> getDomain() {
//		Post: Returns an immutable copy or unmodifiable view of the domain set.
	    return this.domain;
	}
	
	@Override
	public String toString() {
		
//		{[cycle_1]...[cycle_n][fixed_point]} so {[1, 2, 3], [4]}
//		1 -> 2
//		2 -> 3
//		3 -> 1
//		4 -> 4
		StringBuilder sb = new StringBuilder();

	    // --- First line: cycles notation ---
	    sb.append("{");

	    // we can rebuild the cycles by walking the domain using getImage()
	    Set<E> visited = new HashSet<>();
	    for (E e : domain) {
	        if (!visited.contains(e)) {
	            // build one cycle
	            List<E> cycle = new ArrayList<>();
	            E current = e;
	            
	            do {
	                cycle.add(current);
	                visited.add(current);
	                current = imageMap.get(current);
	            } while (!current.equals(e)); // stop when cycle closes

	            sb.append(cycle.toString()); // prints like [1, 2, 3]
	        }
	    }

	    sb.append("}\n"); // end of cycles line

	    // --- Next lines: individual mappings x -> y ---
	    for (E e : domain) {
	        sb.append(e).append(" -> ").append(imageMap.get(e)).append("\n");
	    }

	    return sb.toString();		
	}

	@Override
	public boolean equals(Object obj) {
	    boolean equalsVerdict = true; // assume equal unless we find otherwise

	    if (this == obj) {
	        // same reference — stays true
	    	
	    } else if (!(obj instanceof Permutation)) {
	        equalsVerdict = false;
	        
	    } else {
	    	//casting obj to ours to check similarirty
	        Permutation<E> other = (Permutation<E>) obj;

	        if (!this.domain.equals(other.getDomain())) {
	            equalsVerdict = false;
	            
	        } else {
	            // only check images if domain matches
	            for (E e : this.domain) {
	                E myImage = this.getImage(e);
	                E otherImage = other.getImage(e);

	                // null-safe check
	                if (myImage == null) {
	                    if (otherImage != null) {
	                        equalsVerdict = false;
	                        break;
	                    }
	                } else if (!myImage.equals(otherImage)) {
	                    equalsVerdict = false;
	                    break;
	                }
	            }
	        }
	    }

	    return equalsVerdict;

	}

}