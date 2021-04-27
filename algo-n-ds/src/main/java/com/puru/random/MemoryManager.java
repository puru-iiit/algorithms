package com.puru.random;

import java.util.Map;

public class MemoryManager {

    private int blockSize = 1;

    private int nextAvailableIndex;

    private int maxCapacity;

    private int halfCapacity;

    private Object[]  occupiedMemory;

    private Object[]  freeMemory;

    private Map<Integer, AllocatedDetails> usedMemoryMap;

    private Map<Integer, AllocatedDetails> unUsedMemoryMap;

    public MemoryManager(int maxCapacity){
        this.maxCapacity=maxCapacity;
        this.halfCapacity = maxCapacity/2;
        occupiedMemory = new Object[halfCapacity];
        freeMemory = new Object[halfCapacity];
    }
    public MemoryAllocated malloc(int size){

        if(nextAvailableIndex+size<halfCapacity){
            usedMemoryMap.put(nextAvailableIndex, new AllocatedDetails(nextAvailableIndex,size, nextAvailableIndex));
            nextAvailableIndex = nextAvailableIndex+size;
            return new MemoryAllocated(nextAvailableIndex, size,this);
        }else{
            if(isSufficientMemoryAvailale()){
                compac();
                this.malloc(size);
            }
            throw new IllegalArgumentException("Cannot provide this sized memory for now");
        }


    }

    public boolean deMalloc(MemoryAllocated memoryAllocated){
        usedMemoryMap.remove(memoryAllocated.getStartIndex());
        unUsedMemoryMap.put(memoryAllocated.getStartIndex(),memoryAllocated.getSize() );
       return  true;
    }
    private boolean isSufficientMemoryAvailale() {
        return  false;
    }

    //Method to copy the used memory to unused memory
    private void compac() {
    }
}
class AllocatedDetails {
    public AllocatedDetails(int nextAvailableIndex, int size, int nextAvailableIndex1) {
    }
}

class MemoryAllocated {
    public MemoryAllocated(int availableIndex, int nextAvailableIndex, MemoryManager memoryManager) {
    }

    public Integer getStartIndex() {
        return null;
    }

    public AllocatedDetails getSize() {
        return null;
    }
}


