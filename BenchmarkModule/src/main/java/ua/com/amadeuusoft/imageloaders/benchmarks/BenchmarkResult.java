package ua.com.amadeuusoft.imageloaders.benchmarks;

import java.util.List;

/**
 * Created by Artem on 08.04.2014.
 */
public class BenchmarkResult {

    private String title;

    private List<Float> resultList;
    private List<Float> gpuResultList;

    public BenchmarkResult(String title, List<Float> resultList) {
        this.title = title;
        this.resultList = resultList;
    }

    public List<Float> getResultList() {
        return resultList;
    }

    public void setGpuResultList(List<Float> gpuResultList) {
        this.gpuResultList = gpuResultList;
    }

    public String getTitle() {
        return title;
    }
}
