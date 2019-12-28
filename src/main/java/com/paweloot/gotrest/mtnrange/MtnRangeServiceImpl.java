package com.paweloot.gotrest.mtnrange;

import com.paweloot.gotrest.entity.MtnGroup;
import com.paweloot.gotrest.entity.MtnRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class MtnRangeServiceImpl implements MtnRangeService {

    private MtnRangeRepository repository;

    @Autowired
    public MtnRangeServiceImpl(MtnRangeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MtnRange> findAll() {
        return repository.findAll();
    }

    @Override
    public MtnRange findById(int id) {

        Optional<MtnRange> mtnRange = repository.findById(id);

        return mtnRange.orElse(null);
    }

    @Override
    public List<MtnGroup> findAllMtnGroupsById(int id) {

        Optional<MtnRange> mtnRange = repository.findById(id);

        return mtnRange.map(MtnRange::getMtnGroups).orElse(null);
    }

    @Override
    public void save(MtnRange mtnRange) {
        repository.save(mtnRange);
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }
}
