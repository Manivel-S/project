package com.ideas2it.ems.service.trainerdao;

import java.util.ArrayList;
import java.util.List;

class TrainerDAO {
    static List<Trainer> trainerList = new ArrayList<Trainer>();

    public void addTrainer(Trainer trainer) {
        trainerList.add(trainer);
    }

    public List<Trainer> getTrainer() {
        return trainerList;
    }

    public void updateTrainer(int trainerIndex, Trainer trainer) {
        trainerList.set(trainerIndex, trainer);
    }

    public void deleteTrainer(int trainerIndex) {
        trainerList.remove(trainerIndex);
    }
}