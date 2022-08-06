package org.example.mapper;

import org.example.model.domain.City;
import org.example.util.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * CityMapper
 *
 * @author trang
 */
@Mapper
public interface CityMapper extends BaseMapper<City> {
}