package edu.northeastern.cs5200.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import edu.northeastern.cs5200.models.Course;
import edu.northeastern.cs5200.models.Section;

public interface SectionRepository extends CrudRepository<Section,Integer> {

}
