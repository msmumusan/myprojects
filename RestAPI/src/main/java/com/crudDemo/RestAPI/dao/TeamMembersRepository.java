package com.crudDemo.RestAPI.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.crudDemo.RestAPI.entity.TeamMember;

@Repository
public interface TeamMembersRepository
		extends JpaRepository<TeamMember, Integer> {
	

	@Query("select m from TeamMember m where m.fid = ?1 order by register_date asc")
	List<TeamMember> findById(int id);
	
	
	@Query("select m from TeamMember m where month(m.regiterDate) = ?1")
	List<TeamMember> findByMonth(int month);
	
	@Query("select m from TeamMember m where year(m.regiterDate) = ?1 order by register_date asc")
	List<TeamMember> findByYear(int year);
	
	
	//TeamMember findByIndexNum(int index);
	//void saveTeamMember(List<TeamMember> teamMembersList);
	
	
	//Page<TeamMember> findByTeamId(Long teamId, Pageable pageable);

    //Optional<TeamMember> findByIdAndTeamId(int id, int teamId);
	
	
	
	//@Query("Select p from MethodologyPricing p where p.methodology.id=?1 order by methodology_date ASC")
	//List<MethodologyPricing> findMethodologyPricingById(String id);
	
	
	
	
	//@Query(value = "select m from Members m where m.id = ?1", nativeQuery = true)
	//List<TeamMember> findByIdAndSort(int id, Sort sort);
	
	//List<TeamMember> findById(int id, Sort sort);
	
	
	//	 @Override
	//	    public List<Student> findAll() {
	//	        return studentDao.findAll(orderByIdAsc());
	//	    }
	//	private Sort orderByIdAsc() {
	//   return new Sort(Sort.Direction.ASC, "id")
	//	                .and(new Sort(Sort.Direction.ASC, "name"));
}
