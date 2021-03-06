package com.atlassian.clover.registry.entities;

import com.atlassian.clover.api.registry.ContextSet;
import com.atlassian.clover.api.registry.ElementInfo;
import com.atlassian.clover.api.registry.SourceInfo;
import com.atlassian.clover.spi.lang.LanguageConstruct;
import com.atlassian.clover.registry.FixedSourceRegion;

public class BasicElementInfo implements ElementInfo {
    private FixedSourceRegion region; //May change during instrumentation
    private final int relativeDataIndex;
    private int complexity;
    private LanguageConstruct construct;

    public BasicElementInfo(SourceInfo region, int relativeDataIndex, int complexity, LanguageConstruct construct) {
        this.region = FixedSourceRegion.of(region);
        this.relativeDataIndex = relativeDataIndex;
        this.complexity = complexity;
        this.construct = construct;
    }

    public SourceInfo getRegion() {
        return region;
    }

    public int getRelativeDataIndex() {
        return relativeDataIndex;
    }

    @Override
    public int getHitCount() {
        throw new UnsupportedOperationException("Use FullElementInfo instead");
    }

    @Override
    public ContextSet getContext() {
        throw new UnsupportedOperationException("Use FullElementInfo instead");
    }

    @Override
    public int getComplexity() {
        return complexity;
    }

    @Override
    public int getStartLine() {
        return region.getStartLine();
    }

    @Override
    public int getStartColumn() {
        return region.getStartColumn();
    }

    @Override
    public int getEndLine() {
        return region.getEndLine();
    }

    @Override
    public int getEndColumn() {
        return region.getEndColumn();
    }

    public void setComplexity(int complexity) {
        this.complexity = complexity;
    }

    public void setRegion(SourceInfo region) {
        this.region = FixedSourceRegion.of(region);
    }

    public LanguageConstruct getConstruct() {
        return construct;
    }

    public void setConstruct(LanguageConstruct construct) {
        this.construct = construct;
    }

    ///CLOVER:OFF
    @Override
    public String toString() {
        return "BasicElementInfo{" +
            "region=" + region +
            ", relativeDataIndex=" + relativeDataIndex +
            ", complexity=" + complexity +
            '}';
    }
    ///CLOVER:ON
}
