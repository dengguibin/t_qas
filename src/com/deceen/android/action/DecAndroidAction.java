package com.deceen.android.action;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.deceen.android.model.DataReportingMenuBean;
import com.deceen.android.model.ResultSet;
import com.deceen.android.service.DecAandroidService;
import com.deceen.data.base.course.model.QasDCourse;
import com.deceen.data.base.course.service.QasDCourseService;
import com.deceen.data.base.empolyee.model.QasDEmpolyee;
import com.deceen.data.base.empolyee.service.QasDEmpolyeeService;
import com.deceen.data.base.grade.model.QasDGrade;
import com.deceen.data.base.grade.service.QasDGradeService;
import com.deceen.data.base.student.model.QasDStudent;
import com.deceen.data.base.student.service.QasDStudentService;
import com.deceen.data.fund.fundCostStatistics.model.QasDFundcoststatistics;
import com.deceen.data.fund.fundCostStatistics.service.QasDFundcoststatisticsService;
import com.deceen.data.fund.fundIncomeStatistics.model.QasDFundincomestatistics;
import com.deceen.data.fund.fundIncomeStatistics.service.QasDFundincomestatisticsService;
import com.deceen.data.major.cooperate.model.QasDCooperate;
import com.deceen.data.major.cooperate.service.QasDCooperateService;
import com.deceen.data.major.cooperateCompany.model.QasDCooperatecompany;
import com.deceen.data.major.cooperateCompany.service.QasDCooperatecompanyService;
import com.deceen.data.major.courseMaterial.model.QasDCoursematerial;
import com.deceen.data.major.courseMaterial.service.QasDCoursematerialService;
import com.deceen.data.major.directionStatistics.model.QasDDirectionstatistics;
import com.deceen.data.major.directionStatistics.service.QasDDirectionstatisticsService;
import com.deceen.data.major.graduateEmployment.model.QasDGraduateemployment;
import com.deceen.data.major.graduateEmployment.service.QasDGraduateemploymentService;
import com.deceen.data.major.graduateEmploymentUnits.model.QasDGraduateemploymentunits;
import com.deceen.data.major.graduateEmploymentUnits.service.QasDGraduateemploymentunitsService;
import com.deceen.data.major.graduateInformation.model.QasDGraduateinformation;
import com.deceen.data.major.graduateInformation.service.QasDGraduateinformationService;
import com.deceen.data.major.lastYearEmployment.model.QasDLastyearemployment;
import com.deceen.data.major.lastYearEmployment.service.QasDLastyearemploymentService;
import com.deceen.data.major.majorCourse.model.QasDMajorcourse;
import com.deceen.data.major.majorCourse.service.QasDMajorcourseService;
import com.deceen.data.major.majorLeader.model.QasDMajorleader;
import com.deceen.data.major.majorLeader.service.QasDMajorleaderService;
import com.deceen.data.major.majorQualitativeIndicator.model.QasDMajorqualitativeindicator;
import com.deceen.data.major.majorQualitativeIndicator.service.QasDMajorqualitativeindicatorService;
import com.deceen.data.major.practice.model.QasDPractice;
import com.deceen.data.major.practice.service.QasDPracticeService;
import com.deceen.data.major.recruit.model.QasDRecruit;
import com.deceen.data.major.recruit.service.QasDRecruitService;
import com.deceen.data.school.areaOfStructure.model.QasDAreaofstructure;
import com.deceen.data.school.areaOfStructure.service.QasDAreaofstructureService;
import com.deceen.data.school.booksInLibrary.model.QasDBooksinlibrary;
import com.deceen.data.school.booksInLibrary.service.QasDBooksinlibraryService;
import com.deceen.data.school.collegeEnrolPlan.model.QasDCollegeenrolplan;
import com.deceen.data.school.collegeEnrolPlan.service.QasDCollegeenrolplanService;
import com.deceen.data.school.collegeEnrolType.model.QasDCollegeenroltype;
import com.deceen.data.school.collegeEnrolType.service.QasDCollegeenroltypeService;
import com.deceen.data.school.collegeInSchoolStudent.model.QasDCollegeinschoolstudent;
import com.deceen.data.school.collegeInSchoolStudent.service.QasDCollegeinschoolstudentService;
import com.deceen.data.school.contacter.model.QasDSchoolcontacter;
import com.deceen.data.school.contacter.service.QasDSchoolcontacterService;
import com.deceen.data.school.fixedAssets.model.QasDFixedassets;
import com.deceen.data.school.fixedAssets.service.QasDFixedassetsService;
import com.deceen.data.school.informationConstruction.model.QasDInformationconstruction;
import com.deceen.data.school.informationConstruction.service.QasDInformationconstructionService;
import com.deceen.data.school.leaderAction.model.QasDLeaderaction;
import com.deceen.data.school.leaderAction.service.QasDLeaderactionService;
import com.deceen.data.school.managementInformationSystem.model.QasDManagementinformationsystem;
import com.deceen.data.school.managementInformationSystem.service.QasDManagementinformationsystemService;
import com.deceen.data.school.organizationStatistics.model.QasDOrganizationstatistics;
import com.deceen.data.school.organizationStatistics.service.QasDOrganizationstatisticsService;
import com.deceen.data.school.practiceBaseInCampus.model.QasDPracticebaseincampus;
import com.deceen.data.school.practiceBaseInCampus.service.QasDPracticebaseincampusService;
import com.deceen.data.school.practiceBaseInCampusStatistics.model.QasDPracticebaseincampusstatistics;
import com.deceen.data.school.practiceBaseInCampusStatistics.service.QasDPracticebaseincampusstatisticsService;
import com.deceen.data.school.rooms.model.QasDRooms;
import com.deceen.data.school.rooms.service.QasDRoomsService;
import com.deceen.data.school.school.model.QasDSchool;
import com.deceen.data.school.school.service.QasDSchoolService;
import com.deceen.data.school.shoolAward.model.QasDShoolaward;
import com.deceen.data.school.shoolAward.service.QasDShoolawardService;
import com.deceen.data.school.skillAppraisalOrg.model.QasDSkillappraisalorg;
import com.deceen.data.school.skillAppraisalOrg.service.QasDSkillappraisalorgService;
import com.deceen.data.school.skillAppraisalOrgStatistics.model.QasDSkillappraisalorgstatistics;
import com.deceen.data.school.skillAppraisalOrgStatistics.service.QasDSkillappraisalorgstatisticsService;
import com.deceen.data.school.socialDonation.model.QasDSocialdonation;
import com.deceen.data.school.socialDonation.service.QasDSocialdonationService;
import com.deceen.data.school.trainingBaseOutOfCampus.model.QasDTrainingbaseoutofcampus;
import com.deceen.data.school.trainingBaseOutOfCampus.service.QasDTrainingbaseoutofcampusService;
import com.deceen.data.school.trainingBaseOutOfCampusStatistics.model.QasDTrainingbaseoutofcampusstatistics;
import com.deceen.data.school.trainingBaseOutOfCampusStatistics.service.QasDTrainingbaseoutofcampusstatisticsService;
import com.deceen.data.student.associationAndRedCrossAward.model.QasDAssociationandredcrossaward;
import com.deceen.data.student.associationAndRedCrossAward.service.QasDAssociationandredcrossawardService;
import com.deceen.data.student.dropoutList.model.QasDDropoutlist;
import com.deceen.data.student.dropoutList.service.QasDDropoutlistService;
import com.deceen.data.student.qualification.model.QasDQualification;
import com.deceen.data.student.qualification.service.QasDQualificationService;
import com.deceen.data.student.retiredSoldiers.model.QasDRetiredsoldiers;
import com.deceen.data.student.retiredSoldiers.service.QasDRetiredsoldiersService;
import com.deceen.data.student.skillTraining.model.QasDSkilltraining;
import com.deceen.data.student.skillTraining.service.QasDSkilltrainingService;
import com.deceen.data.student.studAssociation.model.QasDStudassociation;
import com.deceen.data.student.studAssociation.service.QasDStudassociationService;
import com.deceen.data.student.studAssociationStatistics.model.QasDStudassociationstatistics;
import com.deceen.data.student.studAssociationStatistics.service.QasDStudassociationstatisticsService;
import com.deceen.data.student.studRegionInfo.model.QasDStudregioninfo;
import com.deceen.data.student.studRegionInfo.service.QasDStudregioninfoService;
import com.deceen.data.student.studentAward.model.QasDStudentaward;
import com.deceen.data.student.studentAward.service.QasDStudentawardService;
import com.deceen.data.student.studentNormal.model.QasDStudentnormal;
import com.deceen.data.student.studentNormal.service.QasDStudentnormalService;
import com.deceen.data.teacher.lessonsOfTeacher.model.QasDLessonsofteacher;
import com.deceen.data.teacher.lessonsOfTeacher.service.QasDLessonsofteacherService;
import com.deceen.data.teacher.teacherAward.model.QasDTeacheraward;
import com.deceen.data.teacher.teacherAward.service.QasDTeacherawardService;
import com.deceen.data.teacher.teacherPartTimeWork.model.QasDTeacherparttimework;
import com.deceen.data.teacher.teacherPartTimeWork.service.QasDTeacherparttimeworkService;
import com.deceen.data.teacher.teacherProcessStatistics.model.QasDTeacherprocessstatistics;
import com.deceen.data.teacher.teacherProcessStatistics.service.QasDTeacherprocessstatisticsService;
import com.deceen.data.teacher.teacherPublishedPaper.model.QasDTeacherpublishedpaper;
import com.deceen.data.teacher.teacherPublishedPaper.service.QasDTeacherpublishedpaperService;
import com.deceen.data.teacher.teacherResearch.model.QasDTeacherresearch;
import com.deceen.data.teacher.teacherResearch.service.QasDTeacherresearchService;
import com.deceen.data.teacher.teacherSecondment.model.QasDTeachersecondment;
import com.deceen.data.teacher.teacherSecondment.service.QasDTeachersecondmentService;
import com.deceen.data.teacher.teacherTeachingTrain.model.QasDTeacherteachingtrain;
import com.deceen.data.teacher.teacherTeachingTrain.service.QasDTeacherteachingtrainService;
import com.deceen.data.teacher.teacherTechnicalMonopoly.model.QasDTeachertechnicalmonopoly;
import com.deceen.data.teacher.teacherTechnicalMonopoly.service.QasDTeachertechnicalmonopolyService;
import com.deceen.data.teacher.teacherTraining.model.QasDTeachertraining;
import com.deceen.data.teacher.teacherTraining.service.QasDTeachertrainingService;
import com.deceen.data.teaching.baseInfoOfEmploymentGuidance.model.QasDBaseinfoofemploymentguidance;
import com.deceen.data.teaching.baseInfoOfEmploymentGuidance.service.QasDBaseinfoofemploymentguidanceService;
import com.deceen.data.teaching.baseInfoOfSupervisor.model.QasDBaseinfoofsupervisor;
import com.deceen.data.teaching.baseInfoOfSupervisor.service.QasDBaseinfoofsupervisorService;
import com.deceen.data.teaching.baseInfoOfTeachingResearcher.model.QasDBaseinfoofteachingresearcher;
import com.deceen.data.teaching.baseInfoOfTeachingResearcher.service.QasDBaseinfoofteachingresearcherService;
import com.deceen.data.teaching.cooperateProject.model.QasDCooperateproject;
import com.deceen.data.teaching.cooperateProject.service.QasDCooperateprojectService;
import com.deceen.data.teaching.filesOfTeachingManageMent.model.QasDFilesofteachingmanagement;
import com.deceen.data.teaching.filesOfTeachingManageMent.service.QasDFilesofteachingmanagementService;
import com.deceen.data.teaching.innovationMatch.model.QasDInnovationmatch;
import com.deceen.data.teaching.innovationMatch.service.QasDInnovationmatchService;
import com.deceen.data.teaching.innovativeTrainProj.model.QasDInnovativetrainproj;
import com.deceen.data.teaching.innovativeTrainProj.service.QasDInnovativetrainprojService;
import com.deceen.data.teaching.majorSysInnovation.model.QasDMajorsysinnovation;
import com.deceen.data.teaching.majorSysInnovation.service.QasDMajorsysinnovationService;
import com.deceen.data.teaching.scholarship.model.QasDScholarship;
import com.deceen.data.teaching.scholarship.service.QasDScholarshipService;
import com.deceen.data.teaching.skillMasterStudio.model.QasDSkillmasterstudio;
import com.deceen.data.teaching.skillMasterStudio.service.QasDSkillmasterstudioService;
import com.deceen.data.teaching.studentManagement.model.QasDStudentmanagement;
import com.deceen.data.teaching.studentManagement.service.QasDStudentmanagementService;
import com.deceen.data.teaching.teachingEvaluation.model.QasDTeachingevaluation;
import com.deceen.data.teaching.teachingEvaluation.service.QasDTeachingevaluationService;
import com.deceen.data.teaching.teachingManagement.model.QasDTeachingmanagement;
import com.deceen.data.teaching.teachingManagement.service.QasDTeachingmanagementService;
import com.deceen.data.teaching.teachingResource.model.QasDTeachingresource;
import com.deceen.data.teaching.teachingResource.service.QasDTeachingresourceService;
import com.deceen.data.teaching.teachingStdResearchProj.model.QasDTeachingstdresearchproj;
import com.deceen.data.teaching.teachingStdResearchProj.service.QasDTeachingstdresearchprojService;
import com.deceen.data.teaching.technologyInnovationCenter.model.QasDTechnologyinnovationcenter;
import com.deceen.data.teaching.technologyInnovationCenter.service.QasDTechnologyinnovationcenterService;
import com.deceen.data.teaching.virtualSimulationCenter.model.QasDVirtualsimulationcenter;
import com.deceen.data.teaching.virtualSimulationCenter.service.QasDVirtualsimulationcenterService;
import com.deceen.diagnoseformat.scheme.model.QasTDiagnosescheme;
import com.deceen.diagnoseformat.scheme.service.QasTDiagnoseschemeService;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetask;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskdates;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetasklevel;
import com.deceen.diagnoseformat.task.model.QasTDiagnosetaskobj;
import com.deceen.diagnoseformat.task.service.QasTDiagnosetaskService;
import com.deceen.diagnosereport.analy.model.QasTDiagnosticreport;
import com.deceen.diagnosereport.analy.service.QasTDiagnosticreportService;
import com.deceen.indicator.indicatorcatalog.mapper.QasTIndicatorcatalogMapper;
import com.deceen.indicator.indicatorcatalog.model.QasTIndicatorcatalog;
import com.deceen.indicator.indicatorcatalog.service.QasTIndicatorcatalogService;
import com.deceen.indicator.indicatorcatalogextend.model.QasTIndicatorcatalogextend;
import com.deceen.indicator.indicatorcontent.model.QasTIndicatorcontent;
import com.deceen.indicator.indicatorcontent.service.QasTIndicatorcontentService;
import com.deceen.system.major.model.QasDMajor;
import com.deceen.utils.ResultMap;
import com.github.bingoohuang.patchca.utils.encoder.EncoderHelper;
import com.upath.plat.auth.facade.IUser;
import com.upath.plat.auth.model.TRmsMenuinfo;
import com.upath.plat.auth.model.TRmsUser;
import com.upath.plat.auth.service.TRmsMenuinfoService;
import com.upath.plat.auth.service.TRmsUserService;
import com.upath.plat.common.PlatConstant;
import com.upath.plat.common.action.BaseActionSupport;
import com.upath.plat.common.exception.PlatformException;
import com.upath.plat.common.modules.action.CaptchaConfig;
import com.upath.plat.common.service.ICommonService;
import com.upath.plat.common.util.PlatUtil;
import com.upath.plat.common.util.RequestHelper;

/**
 * @ClassName: QasDCourseAction.java
 * @Description: qas_d_course
 * @author upaths@gmail.com
 * @date2017-11-22 16:32:04
 * @version V1.0
 */
@Scope("prototype")
@Component("DecAndroidAction")
@SuppressWarnings({ "rawtypes", "unchecked", "serial","unused" })
public class DecAndroidAction extends BaseActionSupport {

	private static final Logger log = Logger.getLogger(DecAndroidAction.class);
	@Autowired
	private QasTIndicatorcatalogMapper qasTIndicatorcatalogMapper;
	@Autowired
	private DecAandroidService decAandroidService;
	@Autowired
	private TRmsMenuinfoService tRmsMenuinfoService;
	@Autowired
	private  QasTDiagnosetaskService diagnosetaskService;
	@Autowired
	private  QasTDiagnosticreportService diagnosticreportService;
	@Autowired
	private  QasTIndicatorcontentService indicatorcontentservice;
	@Autowired
	private  QasTIndicatorcatalogService qasTIndicatorcatalogService;
	@Autowired
	private  QasDBaseinfoofemploymentguidanceService qasDBaseinfoofemploymentguidanceService;
	@Autowired
	private  QasDBaseinfoofsupervisorService qasDBaseinfoofsupervisorService;
	@Autowired
	private  QasDBaseinfoofteachingresearcherService qasDBaseinfoofteachingresearcherService;
	@Autowired
	private  QasDCooperateprojectService qasDCooperateprojectService;
	@Autowired
	private  QasDFilesofteachingmanagementService qasDFilesofteachingmanagementService;
	@Autowired
	private  QasDInnovationmatchService qasDInnovationmatchService;
	@Autowired
	private  QasDInnovativetrainprojService qasDInnovativetrainprojService;

	private QasDInnovativetrainproj innovativetrainprojbean;
	
	private QasDInnovationmatch innovationmatchbean;
	
	private QasDFilesofteachingmanagement filesOfTeachingManagebean;
	
	private QasDCooperateproject cooperateprojectbean;
	
	private QasDBaseinfoofteachingresearcher teachingResearcherbean;
	@Autowired
	private  QasTDiagnoseschemeService diagnoseschemeService;
	
	private List<QasTDiagnosetasklevel> diagnosetasklevels;
	
	private QasTDiagnosetaskdates diagnosetaskdates;
	
	private List<QasTDiagnosetaskobj> diagnosetaskobjlist;
	
	private QasTDiagnosescheme diagnosescheme;
	
	private  QasTDiagnosetaskobj diagnosetaskobj;
	
	private QasTDiagnosticreport diagnosticreport;
	
	private QasTDiagnosetask diagnosetask;
	@Autowired
	private QasDCourseService couseService;
	@Autowired
	private QasDEmpolyeeService empolyeeservice;
	@Autowired
	private QasDGradeService gradeservice;
	@Autowired
	private QasDStudentService studentservice;
	@Autowired
	private QasDFundcoststatisticsService fundcosservice;
	@Autowired
	private QasDFundincomestatisticsService fundincomesservice;
	@Autowired
	private QasDCooperateService cooperateservice;
	@Autowired
	private QasDCooperatecompanyService cooperatecompanyservice;
	@Autowired
	private QasDCoursematerialService coursematerialservice;
	@Autowired
	private QasDDirectionstatisticsService directionstatisticsservice;
	@Autowired
	private QasDGraduateemploymentService graduateemploymentservice;
	@Autowired
	private QasDGraduateemploymentunitsService graduateemploymentunitsservice;
	@Autowired
	private QasDGraduateinformationService graduateinformationservice;
	@Autowired
	private QasDLastyearemploymentService lastyearemploymentservice;
	@Autowired
	private QasDMajorcourseService majorcourseservice;
	@Autowired
	private QasDMajorleaderService majorleaderservice;
	@Autowired
	private QasDMajorqualitativeindicatorService majorqualitativeindicatorservice;
	@Autowired
	private QasDPracticeService practiceservice;
	@Autowired
	private QasDRecruitService recruitservice;
	@Autowired
	private QasDAreaofstructureService areaofstructureservice;
	@Autowired
	private QasDBooksinlibraryService booksinlibraryservice;
	@Autowired
	private QasDCollegeenrolplanService collegeenrolplanservice;
	@Autowired
	private QasDCollegeenroltypeService collegeenroltypeservice;
	@Autowired
	private QasDCollegeinschoolstudentService collegeinschoolstudentservice;
	@Autowired
	private QasDSchoolcontacterService schoolcontacterservice;
	@Autowired
	private QasDFixedassetsService fixedassetsservice;
	@Autowired
	private QasDMajorsysinnovationService qasDMajorsysinnovationService;
	@Autowired
	private QasDScholarshipService qasDScholarshipService;
	@Autowired
	private QasDSkillmasterstudioService qasDSkillmasterstudioService;
	@Autowired
	private QasDStudentmanagementService qasDStudentmanagementService;
	@Autowired
	private QasDTeachingevaluationService qasDTeachingevaluationService;
	@Autowired
	private QasDTeachingmanagementService qasDTeachingmanagementService;
	@Autowired
	private QasDTeachingstdresearchprojService qasDTeachingstdresearchprojService;
	@Autowired
	private QasDTechnologyinnovationcenterService qasDTechnologyinnovationcenterService;
	@Autowired
	private QasDVirtualsimulationcenterService qasDVirtualsimulationcenterService;
	@Autowired
	private QasDLessonsofteacherService qasDLessonsofteacherService;
	@Autowired
	private QasDTeacherawardService qasDTeacherawardService;
	@Autowired
	private QasDTeacherparttimeworkService qasDTeacherparttimeworkService;
	@Autowired
	private QasDTeacherprocessstatisticsService qasDTeacherprocessstatisticsService;
	@Autowired
	private QasDTeacherpublishedpaperService qasDTeacherpublishedpaperService;
	@Autowired
	private QasDTeacherresearchService qasDTeacherresearchService;
	@Autowired
	private QasDTeachersecondmentService qasDTeachersecondmentService;
	@Autowired
	private QasDTeacherteachingtrainService qasDTeacherteachingtrainService;
	@Autowired
	private QasDTeachertechnicalmonopolyService qasDTeachertechnicalmonopolyService;
	@Autowired
	private QasDTeachertrainingService qasDTeachertrainingService;
	@Autowired
	private QasDTeachingresourceService qasDTeachingresourceService;
	@Autowired
	private QasDInformationconstructionService Informationconstructionservice;
	@Autowired
	private QasDLeaderactionService Leaderactionservice;
	@Autowired
	private QasDManagementinformationsystemService Managementinformationsystemservice;
	@Autowired
	private QasDOrganizationstatisticsService Organizationstatisticsservice;
	@Autowired
	private QasDPracticebaseincampusService Practicebaseincampusservice;
	@Autowired
	private QasDPracticebaseincampusstatisticsService Practicebaseincampusstatisticsservice;
	@Autowired
	private QasDRoomsService Roomsservice;
	@Autowired
	private QasDSchoolService Schoolservice;
	@Autowired
	private QasDShoolawardService Shoolawardservice;
	@Autowired
	private QasDSkillappraisalorgService Skillappraisalorgservice;
	@Autowired
	private QasDSkillappraisalorgstatisticsService Skillappraisalorgstatisticsservice;
	@Autowired
	private QasDAssociationandredcrossawardService qasDAssociationandredcrossawardService;
	@Autowired
	private QasDDropoutlistService qasDDropoutlistService;
	@Autowired
	private QasDQualificationService qasDQualificationService;
	@Autowired
	private QasDRetiredsoldiersService qasDRetiredsoldiersService;
	@Autowired
	private QasDSkilltrainingService qasDSkilltrainingService;
	@Autowired
	private QasDStudassociationService qasDStudassociationService;
	@Autowired
	private QasDStudassociationstatisticsService qsDStudassociationstatisticsService;
	@Autowired
	private QasDStudentawardService qasDStudentawardService;
	@Autowired
	private QasDStudentnormalService qasDStudentnormalService;
	@Autowired
	private QasDStudregioninfoService qasDStudregioninfoService;
	@Autowired
	private QasDSocialdonationService Socialdonationservice;
	@Autowired
	private QasDTrainingbaseoutofcampusService Trainingbaseoutofcampusservice;
	
	private QasDTrainingbaseoutofcampus Trainingbaseoutofcampusbean;
	
	private QasDSocialdonation Socialdonationbean;
	
	private QasDStudregioninfo studregioninfobean;
	
	private QasDStudentnormal studentnormalbean;
	
	private QasDStudentaward studentawardbean;
	
	private QasDStudassociationstatistics studassociationstatisticsbean;
	
	private QasDStudassociation studassociationbean;
	
	private QasDSkilltraining skilltrainingbean;
	
	private QasDRetiredsoldiers retiredsoldiersbean;
	
	private QasDQualification qualificationbean;
	
	private QasDDropoutlist dropoutlistbean;
	
	private QasDAssociationandredcrossaward redcrossawardbean;
	private QasDSkillappraisalorgstatistics Skillappraisalorgstatisticsbean;
	
	private QasDSkillappraisalorg Skillappraisalorgbean;
	
	private QasDShoolaward Shoolawardbean;
	
	private QasDSchool Schoolbean;
	
	private QasDRooms Roomsbean;
	
	private QasDPracticebaseincampusstatistics Practicebaseincampusstatisticsbean;
	
	private QasDPracticebaseincampus Practicebaseincampusbean;
	
	private QasDOrganizationstatistics Organizationstatisticsbean;
	
	private QasDManagementinformationsystem Managementinformationsystembean;
	
	private QasDLeaderaction Leaderactionbean;
	
	private QasDInformationconstruction Informationconstructionbean;
	
	private QasDTeachingresource teachingresourcebean;
	
	private QasDTeachertraining teachertrainingbean;
	
	private QasDTeachertechnicalmonopoly chnicalmonopolybean;
	
	private QasDTeacherteachingtrain teacherteachingtrainbean;
	
	private QasDTeachersecondment teachersecondmentbean;
	
	private QasDTeacherresearch teacherresearchbean;
	
	private QasDTeacherpublishedpaper publishedpaperbean;
	
	private QasDTeacherprocessstatistics processstatisticsbean;
	
	private QasDTeacherparttimework parttimeworkbean;
	
	private QasDTeacheraward teacherawardbean;
	
	private QasDLessonsofteacher lessonsofteacherbean;
	
	private QasDVirtualsimulationcenter simulationcenterbean;
	
	private QasDTechnologyinnovationcenter innovationcenterbean;
	
	private QasDTeachingstdresearchproj teachingstdresearchprojbean;
	
	private QasDTeachingmanagement teachingmanagementbean;
	
	private QasDTeachingevaluation teachingevaluationbean;

	private QasDStudentmanagement studentManagementbean;
	
	private QasDSkillmasterstudio killmasterstudiobean;
	
	private QasDScholarship scholarshipbean;

	private QasDMajorsysinnovation majorsysinnovationbean;
	
	private QasDFixedassets fixedassetsbean;
	
	private QasDSchoolcontacter schoolcontacterbean;
	
	private QasDCollegeinschoolstudent collegeinschoolstudentbean;
	
	private QasDCollegeenroltype collegeenroltypebean;
	
	private QasDCollegeenrolplan collegeenrolplanbean;
	
	private QasDBooksinlibrary booksinlibrarybean;
	
	private QasDAreaofstructure areaofstructurebean;
	
	private QasDRecruit recruitbean;
	
	private QasDPractice practicebean;
	
	private QasDMajorqualitativeindicator majorqualitativeindicatorbean;
	
	private QasDMajorleader majorleaderbean;
	
	private QasDMajorcourse majorcoursebean;
	
	private QasDLastyearemployment lastyearemploymentbean;
	
	private QasDGraduateinformation graduateinformationbean;
	
	private QasDGraduateemploymentunits graduateemploymentunitsbean;
	
	private QasDGraduateemployment graduateemploymentbean;
	
	private QasDDirectionstatistics Directionstatisticsbean;
	
	private QasDCoursematerial Coursematerialbean;
	
	private QasDCooperatecompany cooperatecompanybean;
	
	private QasDCooperate cooperatebean;
	
	private QasDBaseinfoofemploymentguidance qasDBaseGuidanceBean;
	
	private QasDBaseinfoofsupervisor qasBaseSupervisorbean;
	
	private QasDFundincomestatistics fundincomesbean;
	
	private QasDFundcoststatistics fundcosbean;
	
	private QasDStudent studentbean;
	
	private QasDGrade gradebean;
	
	private QasDCourse couesebean;
	
	private QasDEmpolyee empolyeebean;

	private QasTIndicatorcatalog qasTIndicatorcatalogBean;
	
	private List datas;
	 
	private String transId;
	@Autowired
	private QasDTrainingbaseoutofcampusstatisticsService qasDTrainingbaseoutofcampusstatisticsService;
	
	private QasDTrainingbaseoutofcampusstatistics trainingbaseoutofcampusstatisticsbean;
	
	private ICommonService iCommonService;
	@Autowired
	private  TRmsUserService tRmsUserService;
	//初始化状态
	private String initStatus ;
	
	private static final CaptchaConfig cs = new CaptchaConfig();
	
	private String userId;
	
	private String password;
	
	private String newPassword[];

	private String code;
	
	//移动端登录
	public void login() throws IOException{
		/**
		 * 不对空验证码进行验证
		 */
		String msg = null;
		if(msg == null && userId == null){
			msg = "登陆帐号不能为空。";
		}else if(msg == null && password == null){
			msg = "登陆密码不允许为空。";
		}else if(code != null && msg == null){
			Object obj = request.getSession().getAttribute(PlatConstant.SESSION_PATCHCA);
			if(code.equalsIgnoreCase(obj+"") == false){
			msg = "验证码输入不正确";
			}
		}if(msg == null){
			IUser user = (IUser)iCommonService.queryObject("plat.selectUser", userId);
		
			if(user == null){
				msg = "系统中不存在此帐号【"+userId+"】的相关信息。";
			}else{
				String str = PlatUtil.encrypt(password);
				if(str.equals(user.getPassword()) == true){
					//移除会话里面的SESSION信息
					request.getSession().removeAttribute(PlatConstant.SESSION_PATCHCA);
					request.getSession().setAttribute(PlatConstant.SESSION_USER, user);
				}else{
					msg = "请确认您输入的密码的正确性。";
				}
			}
		}
		
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(msg != null){
			request.setAttribute("msg", msg);
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults(msg, null), "yyyy-MM-dd HH:mm:ss");
			//return login();
		}else{
			TRmsUser bean = new TRmsUser();
			bean.setYhid(userId);
			datas = tRmsUserService.list(bean);
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("登录成功",datas), "yyyy-MM-dd HH:mm:ss");
			//return SUCCESS;
		}
		response.getWriter().print(jstr);
	}
	
	//登出
	public void logout() throws PlatformException, IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		try {
			 IUser user = 	RequestHelper.getInstance().getLoginUser();
			 //标识用户为正常退出状态
			 user.setLogOutState("1");
			 request.getSession().invalidate();
			 jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("正常退出",null), "yyyy-MM-dd HH:mm:ss");
		} catch (Exception e) {
			log.error(e);
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(e), "yyyy-MM-dd HH:mm:ss");
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	//生成验证码
	public void code() throws IOException {
		response.setContentType("image/png");
		response.setHeader("cache", "no-cache");
		HttpSession session = request.getSession(true);
			OutputStream os = response.getOutputStream();
			response.reset();
			String patchca= EncoderHelper.getChallangeAndWriteImage(new CaptchaConfig(), "png", os);
			session.setAttribute(PlatConstant.SESSION_PATCHCA, patchca);
			os.flush();
			os.close();
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(patchca), "yyyy-MM-dd HH:mm:ss");
	        response.getWriter().print(jstr);
	}

	//获取数据模板的子列表
	public void getDataBlockMenue() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		//String jstr = null;
		
		/*if(transId == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你没有传递菜单transId值", null), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
			return;
		}*/
		TRmsMenuinfo tRmsMenuinfo = new TRmsMenuinfo();
		/*Integer pcdid = Integer.valueOf("299");
		//最外层目录
		if(pcdid == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("菜单transId没有值", null), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
			return;
		}*/
		tRmsMenuinfo.setPcdid(299);
		List<Map> list = tRmsMenuinfoService.list(tRmsMenuinfo);
		List resultlist = new ArrayList();
		for (Map trm : list) {
			//Integer pcdid = Integer.valueOf((String)trm.get("PCDID"));
			if(trm.get("PCDID") == null){
				continue;
			}
			TRmsMenuinfo menuinfo = new TRmsMenuinfo();
			
			menuinfo.setPcdid((Integer)trm.get("CDID"));
			List rmsList = tRmsMenuinfoService.list(menuinfo);
			DataReportingMenuBean dataReportingMenuBean = new DataReportingMenuBean();
			dataReportingMenuBean.setRankOne(trm);
			dataReportingMenuBean.setRankTwo(rmsList);
			resultlist.add(dataReportingMenuBean);
		}
		
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(resultlist), "yyyy-MM-dd HH:mm:ss");
	    response.getWriter().print(jstr);
		/*JSONArray jsonArr = JSONArray.fromObject(ResultSet.getSuccessfulResults(list));
		response.getWriter().print(jsonArr.toString());*/
	}
	
	//获取诊断对象
	public void getDiagnoseTaskobj() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		QasDMajor major = new QasDMajor();
		major.setOrganizationid("1024-8767UJES0"); 
		List<Map> list = diagnosetaskService.getdiagnosetaskzy(major);
		List resultlist = new ArrayList();
		for (Map trm : list) {
			QasDMajor majors = new QasDMajor();
			majors.setOrganizationid((String) trm.get("ID"));
			List rmsList = diagnosetaskService.getdiagnosetaskzy(majors);
			DataReportingMenuBean dataReportingMenuBean = new DataReportingMenuBean();
			dataReportingMenuBean.setRankOne(trm);
			dataReportingMenuBean.setRankTwo(rmsList);
			resultlist.add(dataReportingMenuBean);
		}
		
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(resultlist), "yyyy-MM-dd HH:mm:ss");
	    response.getWriter().print(jstr);
	}
	
	//获取诊断模型
	public void getdiagnosescheme() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		List list = diagnoseschemeService.getdiagnosescheme(diagnosescheme);
		List resultlist = new ArrayList();
		for (Object trm : list) {
			DataReportingMenuBean dataReportingMenuBean = new DataReportingMenuBean();
			dataReportingMenuBean.setRankOne(trm);
			resultlist.add(dataReportingMenuBean);
		}
		
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(resultlist), "yyyy-MM-dd HH:mm:ss");
	    response.getWriter().print(jstr);
	}
		
	//数据填报-->教研管理菜单-->专职招生就业指导人员 信息查询
	public void listBaseOfEmploymentGuidance() throws IOException{
		if(qasDBaseGuidanceBean == null){ 
			qasDBaseGuidanceBean = new QasDBaseinfoofemploymentguidance();
		}
		datas = qasDBaseinfoofemploymentguidanceService.list(qasDBaseGuidanceBean);
		
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
        response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->专职招生就业指导人员_新增和更新
	public void addBaseOfEmploymentGuidance() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(qasDBaseGuidanceBean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(qasDBaseGuidanceBean.getId() != null && "".equals(qasDBaseGuidanceBean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDBaseinfoofemploymentguidance dsBean = qasDBaseinfoofemploymentguidanceService.select(qasDBaseGuidanceBean.getId());
				if(dsBean != null){
					if (user != null) {
						qasDBaseGuidanceBean.setUpdatedby(user.getUserId());
					}
					qasDBaseGuidanceBean.setId(dsBean.getId());
					qasDBaseGuidanceBean.setCreatedby(dsBean.getCreatedby());
					qasDBaseGuidanceBean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					qasDBaseinfoofemploymentguidanceService.updateWithDyna(qasDBaseGuidanceBean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("数据更新成功",null), "yyyy-MM-dd HH:mm:ss");
					
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在", null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					qasDBaseGuidanceBean.setCreatedby(user.getUserId());
				}
				qasDBaseinfoofemploymentguidanceService.insert(qasDBaseGuidanceBean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("数据增加成功",null), "yyyy-MM-dd HH:mm:ss");
			}
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->专职督导人员_信息查询
	public void listBaseSupervisor() throws IOException{
		if(qasBaseSupervisorbean == null){ 
			qasBaseSupervisorbean = new QasDBaseinfoofsupervisor();
		}
		datas = qasDBaseinfoofsupervisorService.list(qasBaseSupervisorbean);
		
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->专职督导人员_新增和更新
	public void addBaseSupervisor() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(qasBaseSupervisorbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(qasBaseSupervisorbean.getId() != null && "".equals(qasBaseSupervisorbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDBaseinfoofsupervisor dsBean = qasDBaseinfoofsupervisorService.select(qasBaseSupervisorbean.getId());
				if(dsBean != null){
					if (user != null) {
						qasBaseSupervisorbean.setUpdatedby(user.getUserId());
					}
					qasBaseSupervisorbean.setId(dsBean.getId());
					qasBaseSupervisorbean.setCreatedby(dsBean.getCreatedby());
					qasBaseSupervisorbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					qasDBaseinfoofsupervisorService.updateWithDyna(qasBaseSupervisorbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存", null), "yyyy-MM-dd HH:mm:ss");
					
				}
			}else{
				if (user != null) {
					qasBaseSupervisorbean.setCreatedby(user.getUserId());
				}
				qasDBaseinfoofsupervisorService.insert(qasBaseSupervisorbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->专职教学研究人员_信息查询
	public void listTeachingResearcher() throws IOException{
		if(teachingResearcherbean == null){ 
			teachingResearcherbean = new QasDBaseinfoofteachingresearcher();
		}
		datas = qasDBaseinfoofteachingresearcherService.list(teachingResearcherbean);
		
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->专职教学研究人员_新增和更新
	public void addTeachingResearcher() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(teachingResearcherbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(teachingResearcherbean.getId() != null && "".equals(teachingResearcherbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDBaseinfoofteachingresearcher dsBean = qasDBaseinfoofteachingresearcherService.select(teachingResearcherbean.getId());
				if(dsBean != null){
					if (user != null) {
						teachingResearcherbean.setUpdatedby(user.getUserId());
					}
					teachingResearcherbean.setId(dsBean.getId());
					teachingResearcherbean.setCreatedby(dsBean.getCreatedby());
					teachingResearcherbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					qasDBaseinfoofteachingresearcherService.updateWithDyna(teachingResearcherbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功",null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在", null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					teachingResearcherbean.setCreatedby(user.getUserId());
				}
				qasDBaseinfoofteachingresearcherService.insert(teachingResearcherbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("增加成功",null), "yyyy-MM-dd HH:mm:ss");
			}
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->产学研合作项目_信息查询
	public void listCooperateProject() throws IOException{
		if(cooperateprojectbean == null){ 
			cooperateprojectbean = new QasDCooperateproject();
		}
		datas = qasDCooperateprojectService.list(cooperateprojectbean);
		
		response.setContentType("text/json; charset=UTF-8");
        String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
        response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->产学研合作项目_新增和更新
	public void addCooperateProjec() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(cooperateprojectbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(cooperateprojectbean.getId() != null && "".equals(cooperateprojectbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDCooperateproject dsBean = qasDCooperateprojectService.select(cooperateprojectbean.getId());
				if(dsBean != null){
					if (user != null) {
						cooperateprojectbean.setUpdatedby(user.getUserId());
					}
					cooperateprojectbean.setId(dsBean.getId());
					cooperateprojectbean.setCreatedby(dsBean.getCreatedby());
					cooperateprojectbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					qasDCooperateprojectService.updateWithDyna(cooperateprojectbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功",null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					cooperateprojectbean.setCreatedby(user.getUserId());
				}
				qasDCooperateprojectService.insert(cooperateprojectbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("增加成功",null), "yyyy-MM-dd HH:mm:ss");
			}
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->教学与学生管理文件_信息查询
	public void listFilesOfTeachingManage() throws IOException{
		if(filesOfTeachingManagebean == null){ 
			filesOfTeachingManagebean = new QasDFilesofteachingmanagement();
		}
		datas = qasDFilesofteachingmanagementService.list(filesOfTeachingManagebean);
		
		response.setContentType("text/json; charset=UTF-8");
        String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
        response.getWriter().print(jstr);	
	}
	
	//数据填报-->教研管理菜单-->教学与学生管理文件_新增和更新
	public void addFilesOfTeachingManage() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(filesOfTeachingManagebean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(filesOfTeachingManagebean.getId() != null && "".equals(filesOfTeachingManagebean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDFilesofteachingmanagement dsBean = qasDFilesofteachingmanagementService.select(filesOfTeachingManagebean.getId());
				if(dsBean != null){
					if (user != null) {
						filesOfTeachingManagebean.setUpdatedby(user.getUserId());
					}
					filesOfTeachingManagebean.setId(dsBean.getId());
					filesOfTeachingManagebean.setCreatedby(dsBean.getCreatedby());
					filesOfTeachingManagebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					qasDFilesofteachingmanagementService.updateWithDyna(filesOfTeachingManagebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功",null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					filesOfTeachingManagebean.setCreatedby(user.getUserId());
				}
				qasDFilesofteachingmanagementService.insert(filesOfTeachingManagebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("增加成功",null), "yyyy-MM-dd HH:mm:ss");	
			}
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->创新创业竞赛_信息查询
	public void listInnovationMatch() throws IOException{
		if(innovationmatchbean == null){ 
			innovationmatchbean = new QasDInnovationmatch();
		}
		datas = qasDInnovationmatchService.list(innovationmatchbean);
		
		response.setContentType("text/json; charset=UTF-8");
        String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
        response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->创新创业竞赛_新增和更新
	public void addInnovationMatch() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(innovationmatchbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(innovationmatchbean.getId() != null && "".equals(innovationmatchbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDInnovationmatch dsBean = qasDInnovationmatchService.select(innovationmatchbean.getId());
				if(dsBean != null){
					if (user != null) {
						innovationmatchbean.setUpdatedby(user.getUserId());
					}
					innovationmatchbean.setId(dsBean.getId());
					innovationmatchbean.setCreatedby(dsBean.getCreatedby());
					innovationmatchbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					qasDInnovationmatchService.updateWithDyna(innovationmatchbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功",null), "yyyy-MM-dd HH:mm:ss");
					
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					innovationmatchbean.setCreatedby(user.getUserId());
				}
				qasDInnovationmatchService.insert(innovationmatchbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功",null), "yyyy-MM-dd HH:mm:ss");	
			}
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->大学生创新创业训练_信息查询
	public void listInnovativeTrainProj() throws IOException{
		if(innovativetrainprojbean == null){ 
			innovativetrainprojbean = new QasDInnovativetrainproj();
		}
		datas = qasDInnovativetrainprojService.list(innovativetrainprojbean);
		
		response.setContentType("text/json; charset=UTF-8");
        String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
        response.getWriter().print(jstr);
	}
	
	//数据填报-->教研管理菜单-->大学生创新创业训练_新增和更新
	public void addInnovativeTrainProj() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(innovativetrainprojbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(innovativetrainprojbean.getId() != null && "".equals(innovativetrainprojbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDInnovativetrainproj dsBean = qasDInnovativetrainprojService.select(innovativetrainprojbean.getId());
				if(dsBean != null){
					if (user != null) {
						innovativetrainprojbean.setUpdatedby(user.getUserId());
					}
					innovativetrainprojbean.setId(dsBean.getId());
					innovativetrainprojbean.setCreatedby(dsBean.getCreatedby());
					innovativetrainprojbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					qasDInnovativetrainprojService.updateWithDyna(innovativetrainprojbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功",null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					innovativetrainprojbean.setCreatedby(user.getUserId());
				}
				qasDInnovativetrainprojService.insert(innovativetrainprojbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功",null), "yyyy-MM-dd HH:mm:ss");
			}
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}

	//数据填报-->教研管理菜单-->重大制度创新_信息查询
		public void listMajorSysInnovation() throws IOException{
			if (majorsysinnovationbean == null) {
				majorsysinnovationbean = new QasDMajorsysinnovation();
			}
			datas = qasDMajorsysinnovationService.list(majorsysinnovationbean);
			response.setContentType("text/json; charset=UTF-8");
	        String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
	        response.getWriter().print(jstr);
		}
				
		//数据填报-->教研管理菜单-->重大制度创新_新增和更新
		public void addMajorSysInnovation() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if (majorsysinnovationbean != null) {
				IUser user = getLoginUser();
				// 主键记录已经存在，需要进行更新操作
				if (majorsysinnovationbean.getId() != null && "".equals(majorsysinnovationbean.getId()) == false) {
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDMajorsysinnovation dsBean = qasDMajorsysinnovationService.select(majorsysinnovationbean.getId());
					if (dsBean != null) {
						if (user != null) {
							majorsysinnovationbean.setUpdatedby(user.getUserId());
						}
						majorsysinnovationbean.setId(dsBean.getId());
						majorsysinnovationbean.setCreatedby(dsBean.getCreatedby());
						majorsysinnovationbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDMajorsysinnovationService.updateWithDyna(majorsysinnovationbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					} else {
						// 是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				} else {
					if (user != null) {
						majorsysinnovationbean.setCreatedby(user.getUserId());
					}
					qasDMajorsysinnovationService.insert(majorsysinnovationbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->奖助学情况_信息查询
		public void listScholarship() throws IOException{
			if(scholarshipbean == null){ 
				scholarshipbean = new QasDScholarship();
			}
			datas = qasDScholarshipService.list(scholarshipbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->奖助学情况_新增和更新
		public void addScholarship() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(scholarshipbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(scholarshipbean.getId() != null && "".equals(scholarshipbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDScholarship dsBean = qasDScholarshipService.select(scholarshipbean.getId());
					if(dsBean != null){
						if (user != null) {
							scholarshipbean.setUpdatedby(user.getUserId());
						}
						scholarshipbean.setId(dsBean.getId());
						scholarshipbean.setCreatedby(dsBean.getCreatedby());
						scholarshipbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDScholarshipService.updateWithDyna(scholarshipbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						scholarshipbean.setCreatedby(user.getUserId());
					}
					qasDScholarshipService.insert(scholarshipbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->技能大师工作室_信息查询
		public void listSkillMasterStudio() throws IOException{
			if(killmasterstudiobean == null){ 
				killmasterstudiobean = new QasDSkillmasterstudio();
			}
			datas = qasDSkillmasterstudioService.list(killmasterstudiobean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->技能大师工作室_新增和更新
		public void addSkillMasterStudio() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(killmasterstudiobean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(killmasterstudiobean.getId() != null && "".equals(killmasterstudiobean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDSkillmasterstudio dsBean = qasDSkillmasterstudioService.select(killmasterstudiobean.getId());
					if(dsBean != null){
						if (user != null) {
							killmasterstudiobean.setUpdatedby(user.getUserId());
						}
						killmasterstudiobean.setId(dsBean.getId());
						killmasterstudiobean.setCreatedby(dsBean.getCreatedby());
						killmasterstudiobean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDSkillmasterstudioService.updateWithDyna(killmasterstudiobean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						killmasterstudiobean.setCreatedby(user.getUserId());
					}
					qasDSkillmasterstudioService.insert(killmasterstudiobean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->专职学生管理人员、信息查询
		public void listStudentManagement() throws IOException{
			if (studentManagementbean == null) {
				studentManagementbean = new QasDStudentmanagement();
			}
			datas = qasDStudentmanagementService.list(studentManagementbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->专职学生管理人员、新增和更新
		public void addStudentManagement() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if (studentManagementbean != null) {
				IUser user = getLoginUser();
				// 主键记录已经存在，需要进行更新操作
				if (studentManagementbean.getId() != null && "".equals(studentManagementbean.getId()) == false) {
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDStudentmanagement dsBean = qasDStudentmanagementService.select(studentManagementbean.getId());
					if (dsBean != null) {
						if (user != null) {
							studentManagementbean.setUpdatedby(user.getUserId());
						}
						studentManagementbean.setId(dsBean.getId());
						studentManagementbean.setCreatedby(dsBean.getCreatedby());
						studentManagementbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDStudentmanagementService.updateWithDyna(studentManagementbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					} else {
						// 是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				} else {
					if (user != null) {
						studentManagementbean.setCreatedby(user.getUserId());
					}
					qasDStudentmanagementService.insert(studentManagementbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->评教情况、信息查询
		public void listTeachingEvaluation() throws IOException{
			if (teachingevaluationbean == null) {
				teachingevaluationbean = new QasDTeachingevaluation();
			}
			datas = qasDTeachingevaluationService.list(teachingevaluationbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->评教情况、新增和更新
		public void addTeachingEvaluation() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if (teachingevaluationbean != null) {
				IUser user = getLoginUser();
				// 主键记录已经存在，需要进行更新操作
				if (teachingevaluationbean.getId() != null && "".equals(teachingevaluationbean.getId()) == false) {
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeachingevaluation dsBean = qasDTeachingevaluationService.select(teachingevaluationbean.getId());
					if (dsBean != null) {
						if (user != null) {
							teachingevaluationbean.setUpdatedby(user.getUserId());
						}
						teachingevaluationbean.setId(dsBean.getId());
						teachingevaluationbean.setCreatedby(dsBean.getCreatedby());
						teachingevaluationbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeachingevaluationService.updateWithDyna(teachingevaluationbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					} else {
						// 是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				} else {
					if (user != null) {
						teachingevaluationbean.setCreatedby(user.getUserId());
					}
					qasDTeachingevaluationService.insert(teachingevaluationbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->专职教学管理人员、信息查询
		public void listeachingManagement() throws IOException{
			if (teachingmanagementbean == null) {
				teachingmanagementbean = new QasDTeachingmanagement();
			}
			datas = qasDTeachingmanagementService.list(teachingmanagementbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->专职教学管理人员、新增和更新
		public void addeachingManagement() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if (teachingmanagementbean != null) {
				IUser user = getLoginUser();
				// 主键记录已经存在，需要进行更新操作
				if (teachingmanagementbean.getId() != null && "".equals(teachingmanagementbean.getId()) == false) {
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeachingmanagement dsBean = qasDTeachingmanagementService.select(teachingmanagementbean.getId());
					if (dsBean != null) {
						if (user != null) {
							teachingmanagementbean.setUpdatedby(user.getUserId());
						}
						teachingmanagementbean.setId(dsBean.getId());
						teachingmanagementbean.setCreatedby(dsBean.getCreatedby());
						teachingmanagementbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeachingmanagementService.updateWithDyna(teachingmanagementbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					} else {
						// 是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				} else {
					if (user != null) {
						teachingmanagementbean.setCreatedby(user.getUserId());
					}
					qasDTeachingmanagementService.insert(teachingmanagementbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->专业教学资源库、信息查询
		public void listTeachingResource() throws IOException{
			if(teachingresourcebean == null){ 
				teachingresourcebean = new QasDTeachingresource();
			}
			datas = qasDTeachingresourceService.list(teachingresourcebean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->专业教学资源库、新增和更新
		public void addTeachingResource() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(teachingresourcebean != null){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(teachingresourcebean.getId() != null && "".equals(teachingresourcebean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeachingresource dsBean = qasDTeachingresourceService.select(teachingresourcebean.getId());
					if(dsBean != null){
						if (user != null) {
							teachingresourcebean.setUpdatedby(user.getUserId());
						}
						teachingresourcebean.setId(dsBean.getId());
						teachingresourcebean.setCreatedby(dsBean.getCreatedby());
						teachingresourcebean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeachingresourceService.updateWithDyna(teachingresourcebean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						teachingresourcebean.setCreatedby(user.getUserId());
					}
					qasDTeachingresourceService.insert(teachingresourcebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->教育教学改革、信息查询
		public void listTeachingStdResearchProj() throws IOException{
			if(teachingstdresearchprojbean == null){ 
				teachingstdresearchprojbean = new QasDTeachingstdresearchproj();
			}
			datas = qasDTeachingstdresearchprojService.list(teachingstdresearchprojbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->教育教学改革、新增和更新
		public void addTeachingStdResearchProj() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(teachingstdresearchprojbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(teachingstdresearchprojbean.getId() != null && "".equals(teachingstdresearchprojbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeachingstdresearchproj dsBean = qasDTeachingstdresearchprojService.select(teachingstdresearchprojbean.getId());
					if(dsBean != null){
						if (user != null) {
							teachingstdresearchprojbean.setUpdatedby(user.getUserId());
						}
						teachingstdresearchprojbean.setId(dsBean.getId());
						teachingstdresearchprojbean.setCreatedby(dsBean.getCreatedby());
						teachingstdresearchprojbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeachingstdresearchprojService.updateWithDyna(teachingstdresearchprojbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						teachingstdresearchprojbean.setCreatedby(user.getUserId());
					}
					qasDTeachingstdresearchprojService.insert(teachingstdresearchprojbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}

		//数据填报-->教研管理菜单-->协调发展协同育人心、信息查询
		public void listTechnologyinnovationcenter() throws IOException{
			if(innovationcenterbean == null){ 
				innovationcenterbean = new QasDTechnologyinnovationcenter();
			}
			datas = qasDTechnologyinnovationcenterService.list(innovationcenterbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		
		//数据填报-->教研管理菜单-->协调发展协同育人心、新增和更新
		public void addTechnologyinnovationcenter() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(innovationcenterbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(innovationcenterbean.getId() != null && "".equals(innovationcenterbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTechnologyinnovationcenter dsBean = qasDTechnologyinnovationcenterService.select(innovationcenterbean.getId());
					if(dsBean != null){
						if (user != null) {
							innovationcenterbean.setUpdatedby(user.getUserId());
						}
						innovationcenterbean.setId(dsBean.getId());
						innovationcenterbean.setCreatedby(dsBean.getCreatedby());
						innovationcenterbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTechnologyinnovationcenterService.updateWithDyna(innovationcenterbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						innovationcenterbean.setCreatedby(user.getUserId());
					}
					qasDTechnologyinnovationcenterService.insert(innovationcenterbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->职业能力培养仿真中心、信息查询
		public void listVirtualSimulationCenter() throws IOException{
			if (simulationcenterbean == null) {
				simulationcenterbean = new QasDVirtualsimulationcenter();
			}
			datas = qasDVirtualsimulationcenterService.list(simulationcenterbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教研管理菜单-->职业能力培养仿真中心、新增和跟新
		public void addVirtualSimulationCenter() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if (simulationcenterbean != null) {
				IUser user = getLoginUser();
				// 主键记录已经存在，需要进行更新操作
				if (simulationcenterbean.getId() != null && "".equals(simulationcenterbean.getId()) == false) {
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDVirtualsimulationcenter dsBean = qasDVirtualsimulationcenterService.select(simulationcenterbean
							.getId());
					if (dsBean != null) {
						if (user != null) {
							simulationcenterbean.setUpdatedby(user.getUserId());
						}
						simulationcenterbean.setId(dsBean.getId());
						simulationcenterbean.setCreatedby(dsBean.getCreatedby());
						simulationcenterbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDVirtualsimulationcenterService.updateWithDyna(simulationcenterbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					} else {
						// 是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				} else {
					if (user != null) {
						simulationcenterbean.setCreatedby(user.getUserId());
					}
					qasDVirtualsimulationcenterService.insert(simulationcenterbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
			
		}
		
		//数据填报-->教师菜单-->教师授课统计、信息查询
		public void listLessonsOfTeacher() throws IOException{
			if(lessonsofteacherbean == null){ 
				lessonsofteacherbean = new QasDLessonsofteacher();
			}
			datas = qasDLessonsofteacherService.list(lessonsofteacherbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->教师菜单-->教师授课统计、新增和更新
		public void addLessonsOfTeacher() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(lessonsofteacherbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(lessonsofteacherbean.getId() != null && "".equals(lessonsofteacherbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDLessonsofteacher dsBean = qasDLessonsofteacherService.select(lessonsofteacherbean.getId());
					if(dsBean != null){
						if (user != null) {
							lessonsofteacherbean.setUpdatedby(user.getUserId());
						}
						lessonsofteacherbean.setId(dsBean.getId());
						lessonsofteacherbean.setCreatedby(dsBean.getCreatedby());
						lessonsofteacherbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDLessonsofteacherService.updateWithDyna(lessonsofteacherbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						lessonsofteacherbean.setCreatedby(user.getUserId());
					}
					qasDLessonsofteacherService.insert(lessonsofteacherbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师奖金项目、信息查询
		public void listTeacherAward() throws IOException{
			if(teacherawardbean == null){ 
				teacherawardbean = new QasDTeacheraward();
			}
			datas = qasDTeacherawardService.list(teacherawardbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->教师菜单-->教师奖金项目、新增和更新
		public void addTeacherAward() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(teacherawardbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(teacherawardbean.getId() != null && "".equals(teacherawardbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeacheraward dsBean = qasDTeacherawardService.select(teacherawardbean.getId());
					if(dsBean != null){
						if (user != null) {
							teacherawardbean.setUpdatedby(user.getUserId());
						}
						teacherawardbean.setId(dsBean.getId());
						teacherawardbean.setCreatedby(dsBean.getCreatedby());
						teacherawardbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeacherawardService.updateWithDyna(teacherawardbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						teacherawardbean.setCreatedby(user.getUserId());
					}
					qasDTeacherawardService.insert(teacherawardbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师社会兼职、信息查询
		public void listTeacherPartTimeWork() throws IOException{
			if(parttimeworkbean == null){ 
				parttimeworkbean = new QasDTeacherparttimework();
			}
			datas = qasDTeacherparttimeworkService.list(parttimeworkbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师社会兼职、新增和更新
		public void addTeacherPartTimeWork() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(parttimeworkbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(parttimeworkbean.getId() != null && "".equals(parttimeworkbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeacherparttimework dsBean = qasDTeacherparttimeworkService.select(parttimeworkbean.getId());
					if(dsBean != null){
						if (user != null) {
							parttimeworkbean.setUpdatedby(user.getUserId());
						}
						parttimeworkbean.setId(dsBean.getId());
						parttimeworkbean.setCreatedby(dsBean.getCreatedby());
						parttimeworkbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeacherparttimeworkService.updateWithDyna(parttimeworkbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						parttimeworkbean.setCreatedby(user.getUserId());
					}
					qasDTeacherparttimeworkService.insert(parttimeworkbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师教学过程统计、信息查询
		public void listTeacherProcessStatistics() throws IOException{
			if (processstatisticsbean == null) {
				processstatisticsbean = new QasDTeacherprocessstatistics();
			}
			datas = qasDTeacherprocessstatisticsService.list(processstatisticsbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师教学过程统计、新增和更新
		public void addTeacherProcessStatistics() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if (processstatisticsbean != null) {
				IUser user = getLoginUser();
				// 主键记录已经存在，需要进行更新操作
				if (processstatisticsbean.getId() != null && "".equals(processstatisticsbean.getId()) == false) {
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeacherprocessstatistics dsBean = qasDTeacherprocessstatisticsService.select(processstatisticsbean
							.getId());
					if (dsBean != null) {
						if (user != null) {
							processstatisticsbean.setUpdatedby(user.getUserId());
						}
						processstatisticsbean.setId(dsBean.getId());
						processstatisticsbean.setCreatedby(dsBean.getCreatedby());
						processstatisticsbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeacherprocessstatisticsService.updateWithDyna(processstatisticsbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					} else {
						// 是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				} else {
					if (user != null) {
						processstatisticsbean.setCreatedby(user.getUserId());
					}
					qasDTeacherprocessstatisticsService.insert(processstatisticsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
			
		//数据填报-->教师菜单-->教师公开出版著作论文、信息查询
		public void listTeacherPublishedPaper() throws IOException{
			if (publishedpaperbean == null) {
				publishedpaperbean = new QasDTeacherpublishedpaper();
			}
			datas = qasDTeacherpublishedpaperService.list(publishedpaperbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师公开出版著作论文、新增和更新
		public void addTeacherPublishedPaper() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if (publishedpaperbean != null) {
				IUser user = getLoginUser();
				// 主键记录已经存在，需要进行更新操作
				if (publishedpaperbean.getId() != null && "".equals(publishedpaperbean.getId()) == false) {
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeacherpublishedpaper dsBean = qasDTeacherpublishedpaperService.select(publishedpaperbean.getId());
					if (dsBean != null) {
						if (user != null) {
							publishedpaperbean.setUpdatedby(user.getUserId());
						}
						publishedpaperbean.setId(dsBean.getId());
						publishedpaperbean.setCreatedby(dsBean.getCreatedby());
						publishedpaperbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeacherpublishedpaperService.updateWithDyna(publishedpaperbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					} else {
						// 是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				} else {
					if (user != null) {
						publishedpaperbean.setCreatedby(user.getUserId());
					}
					qasDTeacherpublishedpaperService.insert(publishedpaperbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师在研课题、信息查询
		public void listTeacherResearch() throws IOException{
			if(teacherresearchbean == null){ 
				teacherresearchbean = new QasDTeacherresearch();
			}
			datas = qasDTeacherresearchService.list(teacherresearchbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师在研课题、新增和更新
		public void addTeacherResearch() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(teacherresearchbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(teacherresearchbean.getId() != null && "".equals(teacherresearchbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeacherresearch dsBean = qasDTeacherresearchService.select(teacherresearchbean.getId());
					if(dsBean != null){
						if (user != null) {
							teacherresearchbean.setUpdatedby(user.getUserId());
						}
						teacherresearchbean.setId(dsBean.getId());
						teacherresearchbean.setCreatedby(dsBean.getCreatedby());
						teacherresearchbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeacherresearchService.updateWithDyna(teacherresearchbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						teacherresearchbean.setCreatedby(user.getUserId());
					}
					qasDTeacherresearchService.insert(teacherresearchbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师挂职锻炼、信息查询
		public void listTeacherSecondment() throws IOException{
			if(teachersecondmentbean == null){ 
				teachersecondmentbean = new QasDTeachersecondment();
			}
			datas = qasDTeachersecondmentService.list(teachersecondmentbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师挂职锻炼、新增和更新
		public void addTeacherSecondment() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(teachersecondmentbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(teachersecondmentbean.getId() != null && "".equals(teachersecondmentbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeachersecondment dsBean = qasDTeachersecondmentService.select(teachersecondmentbean.getId());
					if(dsBean != null){
						if (user != null) {
							teachersecondmentbean.setUpdatedby(user.getUserId());
						}
						teachersecondmentbean.setId(dsBean.getId());
						teachersecondmentbean.setCreatedby(dsBean.getCreatedby());
						teachersecondmentbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeachersecondmentService.updateWithDyna(teachersecondmentbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						teachersecondmentbean.setCreatedby(user.getUserId());
					}
					qasDTeachersecondmentService.insert(teachersecondmentbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师教学静修、信息查询
		public void listTeacherTeachingTrain() throws IOException{
			if(teacherteachingtrainbean == null){ 
				teacherteachingtrainbean = new QasDTeacherteachingtrain();
			}
			datas = qasDTeacherteachingtrainService.list(teacherteachingtrainbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师教学静修、新增和更新
		public void addTeacherTeachingTrain() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(teacherteachingtrainbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(teacherteachingtrainbean.getId() != null && "".equals(teacherteachingtrainbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeacherteachingtrain dsBean = qasDTeacherteachingtrainService.select(teacherteachingtrainbean.getId());
					if(dsBean != null){
						if (user != null) {
							teacherteachingtrainbean.setUpdatedby(user.getUserId());
						}
						teacherteachingtrainbean.setId(dsBean.getId());
						teacherteachingtrainbean.setCreatedby(dsBean.getCreatedby());
						teacherteachingtrainbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeacherteachingtrainService.updateWithDyna(teacherteachingtrainbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						teacherteachingtrainbean.setCreatedby(user.getUserId());
					}	
					qasDTeacherteachingtrainService.insert(teacherteachingtrainbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师技术专利、信息查询
		public void listTeacherTechnicalMonopoly() throws IOException{
			if(chnicalmonopolybean == null){ 
				chnicalmonopolybean = new QasDTeachertechnicalmonopoly();
			}
			datas = qasDTeachertechnicalmonopolyService.list(chnicalmonopolybean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师技术专利、新增和更新
		public void addTeacherTechnicalMonopoly() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(chnicalmonopolybean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(chnicalmonopolybean.getId() != null && "".equals(chnicalmonopolybean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeachertechnicalmonopoly dsBean = qasDTeachertechnicalmonopolyService.select(chnicalmonopolybean.getId());
					if(dsBean != null){
						if (user != null) {
							chnicalmonopolybean.setUpdatedby(user.getUserId());
						}
						chnicalmonopolybean.setId(dsBean.getId());
						chnicalmonopolybean.setCreatedby(dsBean.getCreatedby());
						chnicalmonopolybean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeachertechnicalmonopolyService.updateWithDyna(chnicalmonopolybean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						chnicalmonopolybean.setCreatedby(user.getUserId());
					}
					qasDTeachertechnicalmonopolyService.insert(chnicalmonopolybean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师培训进修、信息查询
		public void listTeacherTraining() throws IOException{
			if(teachertrainingbean == null){ 
				teachertrainingbean = new QasDTeachertraining();
			}
			datas = qasDTeachertrainingService.list(teachertrainingbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->教师菜单-->教师培训进修、新增和更新
		public void addTeacherTraining() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(teachertrainingbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(teachertrainingbean.getId() != null && "".equals(teachertrainingbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTeachertraining dsBean = qasDTeachertrainingService.select(teachertrainingbean.getId());
					if(dsBean != null){
						if (user != null) {
							teachertrainingbean.setUpdatedby(user.getUserId());
						}
						teachertrainingbean.setId(dsBean.getId());
						teachertrainingbean.setCreatedby(dsBean.getCreatedby());
						teachertrainingbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDTeachertrainingService.updateWithDyna(teachertrainingbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						teachertrainingbean.setCreatedby(user.getUserId());
					}
					qasDTeachertrainingService.insert(teachertrainingbean);
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->学生社团红十字会获奖、信息查询
		public void listAssociationAndRedCrossAward() throws IOException{
			if(redcrossawardbean == null){ 
				redcrossawardbean = new QasDAssociationandredcrossaward();
			}
			datas = qasDAssociationandredcrossawardService.list(redcrossawardbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->学生社团红十字会获奖、新增和更新
		public void addAssociationAndRedCrossAwar() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(redcrossawardbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(redcrossawardbean.getId() != null && "".equals(redcrossawardbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDAssociationandredcrossaward dsBean = qasDAssociationandredcrossawardService.select(redcrossawardbean.getId());
					if(dsBean != null){
						if (user != null) {
							redcrossawardbean.setUpdatedby(user.getUserId());
						}
						redcrossawardbean.setId(dsBean.getId());
						redcrossawardbean.setCreatedby(dsBean.getCreatedby());
						redcrossawardbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDAssociationandredcrossawardService.updateWithDyna(redcrossawardbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						redcrossawardbean.setCreatedby(user.getUserId());
					}
					qasDAssociationandredcrossawardService.insert(redcrossawardbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->辍学学生明细、信息查询
		public void listDropoutList() throws IOException{
			if(dropoutlistbean == null){ 
				dropoutlistbean = new QasDDropoutlist();
			}
			datas = qasDDropoutlistService.list(dropoutlistbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->辍学学生明细、新增和更新
		public void addDropoutList() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(dropoutlistbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(dropoutlistbean.getId() != null && "".equals(dropoutlistbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDDropoutlist dsBean = qasDDropoutlistService.select(dropoutlistbean.getId());
					if(dsBean != null){
						if (user != null) {
							dropoutlistbean.setUpdatedby(user.getUserId());
						}
						dropoutlistbean.setId(dsBean.getId());
						dropoutlistbean.setCreatedby(dsBean.getCreatedby());
						dropoutlistbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDDropoutlistService.updateWithDyna(dropoutlistbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						dropoutlistbean.setCreatedby(user.getUserId());
					}
					qasDDropoutlistService.insert(dropoutlistbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->职业资格证书统计、信息查询
		public void listQualification() throws IOException{
			if(qualificationbean == null){ 
				datas = qasDQualificationService.list(new HashMap());
			}else{
				datas = qasDQualificationService.list(qualificationbean);
			}
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->职业资格证书统计、新增和更新
		public void addQualification() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(qualificationbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(qualificationbean.getId() != null && "".equals(qualificationbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDQualification dsBean = qasDQualificationService.select(qualificationbean.getId());
					if(dsBean != null){
						if (user != null) {
							qualificationbean.setUpdatedby(user.getUserId());
						}
						qualificationbean.setId(dsBean.getId());
						qualificationbean.setCreatedby(dsBean.getCreatedby());
						qualificationbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDQualificationService.updateWithDyna(qualificationbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						qualificationbean.setCreatedby(user.getUserId());
					}
					qasDQualificationService.insert(qualificationbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->复转军人及退役士兵、信息查询
		public void listRetiredSoldiers() throws IOException{
			if(retiredsoldiersbean == null){ 
				datas = qasDRetiredsoldiersService.list(new HashMap());
			}else{
				datas = qasDRetiredsoldiersService.list(retiredsoldiersbean);
			}
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->复转军人及退役士兵、新增和更新
		public void addRetiredSoldiers() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(retiredsoldiersbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(retiredsoldiersbean.getId() != null && "".equals(retiredsoldiersbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDRetiredsoldiers dsBean = qasDRetiredsoldiersService.select(retiredsoldiersbean.getId());
					if(dsBean != null){
						if (user != null) {
							retiredsoldiersbean.setUpdatedby(user.getUserId());
						}
						retiredsoldiersbean.setId(dsBean.getId());
						retiredsoldiersbean.setCreatedby(dsBean.getCreatedby());
						retiredsoldiersbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDRetiredsoldiersService.updateWithDyna(retiredsoldiersbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						retiredsoldiersbean.setCreatedby(user.getUserId());
					}
					qasDRetiredsoldiersService.insert(retiredsoldiersbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->应届生获证及社会培训、信息查询
		public void listSkillTraining() throws IOException{
			if(skilltrainingbean == null){ 
				datas = qasDSkilltrainingService.list(new HashMap());
			}else{
				datas = qasDSkilltrainingService.list(skilltrainingbean);
			}
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->应届生获证及社会培训、新增和更新
		public void addSkillTraining() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(skilltrainingbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(skilltrainingbean.getId() != null && "".equals(skilltrainingbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDSkilltraining dsBean = qasDSkilltrainingService.select(skilltrainingbean.getId());
					if(dsBean != null){
						if (user != null) {
							skilltrainingbean.setUpdatedby(user.getUserId());
						}
						skilltrainingbean.setId(dsBean.getId());
						skilltrainingbean.setCreatedby(dsBean.getCreatedby());
						skilltrainingbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDSkilltrainingService.updateWithDyna(skilltrainingbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						skilltrainingbean.setCreatedby(user.getUserId());
					}
					qasDSkilltrainingService.insert(skilltrainingbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->学生社团、信息查询
		public void listStudAssociation() throws IOException{
			if(studassociationbean == null){ 
				studassociationbean = new QasDStudassociation();
			}
			datas = qasDStudassociationService.list(studassociationbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->学生社团、新增和更新
		public void addStudAssociation() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(studassociationbean != null  ){
				//主键记录已经存在，需要进行更新操作
				if(studassociationbean.getId() != null && "".equals(studassociationbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDStudassociation dsBean = qasDStudassociationService.select(studassociationbean.getId());
					if(dsBean != null){
						// 如果数据库中有此记录信息，进行更新操作
						qasDStudassociationService.update(studassociationbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					qasDStudassociationService.insert(studassociationbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->学生社团统计、信息查询
		public void listStudAssociationStatistics() throws IOException{
			if(studassociationstatisticsbean == null){ 
				studassociationstatisticsbean = new QasDStudassociationstatistics();
			}
			datas = qsDStudassociationstatisticsService.list(studassociationstatisticsbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->学生社团统计、新增和更新
		public void addStudAssociationStatistics() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(studassociationstatisticsbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(studassociationstatisticsbean.getId() != null && "".equals(studassociationstatisticsbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDStudassociationstatistics dsBean = qsDStudassociationstatisticsService.select(studassociationstatisticsbean.getId());
					if(dsBean != null){
						if (user != null) {
							studassociationstatisticsbean.setUpdatedby(user.getUserId());
						}
						studassociationstatisticsbean.setId(dsBean.getId());
						studassociationstatisticsbean.setCreatedby(dsBean.getCreatedby());
						studassociationstatisticsbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qsDStudassociationstatisticsService.updateWithDyna(studassociationstatisticsbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						studassociationstatisticsbean.setCreatedby(user.getUserId());
					}
					qsDStudassociationstatisticsService.insert(studassociationstatisticsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->学生获奖情况、信息查询
		public void listStudentAward() throws IOException{
			if(studentawardbean == null){ 
				studentawardbean = new QasDStudentaward();
			}
			datas = qasDStudentawardService.list(studentawardbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		//数据填报-->学生菜单-->学生获奖情况、新增和更新
		public void addStudentAward() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(studentawardbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(studentawardbean.getId() != null && "".equals(studentawardbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDStudentaward dsBean = qasDStudentawardService.select(studentawardbean.getId());
					if(dsBean != null){
						if (user != null) {
							studentawardbean.setUpdatedby(user.getUserId());
						}
						studentawardbean.setId(dsBean.getId());
						studentawardbean.setCreatedby(dsBean.getCreatedby());
						studentawardbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDStudentawardService.updateWithDyna(studentawardbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						studentawardbean.setCreatedby(user.getUserId());
					}
					qasDStudentawardService.insert(studentawardbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->学生日常表现统计、信息查询
		public void listStudentNormal() throws IOException{
			if(studentnormalbean == null){ 
				studentnormalbean = new QasDStudentnormal();
			}
			datas = qasDStudentnormalService.list(studentnormalbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->学生日常表现统、新增和更新
		public void addStudentNormal() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(studentnormalbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(studentnormalbean.getId() != null && "".equals(studentnormalbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDStudentnormal dsBean = qasDStudentnormalService.select(studentnormalbean.getId());
					if(dsBean != null){
						if (user != null) {
							studentnormalbean.setUpdatedby(user.getUserId());
						}
						studentnormalbean.setId(dsBean.getId());
						studentnormalbean.setCreatedby(dsBean.getCreatedby());
						studentnormalbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDStudentnormalService.updateWithDyna(studentnormalbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						studentnormalbean.setCreatedby(user.getUserId());
					}
					qasDStudentnormalService.insert(studentnormalbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->在校生地区，民族户口、信息查询
		public void listStudRegionInfo() throws IOException{
			if(studregioninfobean == null){ 
				studregioninfobean = new QasDStudregioninfo();
			}
			datas = qasDStudregioninfoService.list(studregioninfobean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报-->学生菜单-->在校生地区，民族户口、新增和更新
		public void addStudRegionInfo() throws IOException{
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(studregioninfobean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(studregioninfobean.getId() != null && "".equals(studregioninfobean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDStudregioninfo dsBean = qasDStudregioninfoService.select(studregioninfobean.getId());
					if(dsBean != null){
						if (user != null) {
							studregioninfobean.setUpdatedby(user.getUserId());
						}
						studregioninfobean.setId(dsBean.getId());
						studregioninfobean.setCreatedby(dsBean.getCreatedby());
						studregioninfobean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						qasDStudregioninfoService.updateWithDyna(studregioninfobean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						studregioninfobean.setCreatedby(user.getUserId());
					}
					qasDStudregioninfoService.insert(studregioninfobean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
			response.getWriter().print(jstr);
		}
		
	//数据填报-->学校菜单-->校外实习基地统计、信息查询
	public void listTrainingBaseOutOfCampusStatistics() throws IOException{
		if(trainingbaseoutofcampusstatisticsbean == null){ 
			datas = qasDTrainingbaseoutofcampusstatisticsService.list(new HashMap());
		}else{
			datas = qasDTrainingbaseoutofcampusstatisticsService.list(trainingbaseoutofcampusstatisticsbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
		
	//数据填报-->学校菜单-->校外实习基地统计、新增和更新	
	public void addTrainingBaseOutOfCampusStatistics() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(trainingbaseoutofcampusstatisticsbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(trainingbaseoutofcampusstatisticsbean.getId() != null && "".equals(trainingbaseoutofcampusstatisticsbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDTrainingbaseoutofcampusstatistics dsBean = qasDTrainingbaseoutofcampusstatisticsService.select(trainingbaseoutofcampusstatisticsbean.getId());
				if(dsBean != null){
					if (user != null) {
						trainingbaseoutofcampusstatisticsbean.setUpdatedby(user.getUserId());
					}
					trainingbaseoutofcampusstatisticsbean.setId(dsBean.getId());
					trainingbaseoutofcampusstatisticsbean.setCreatedby(dsBean.getCreatedby());
					trainingbaseoutofcampusstatisticsbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					qasDTrainingbaseoutofcampusstatisticsService.updateWithDyna(trainingbaseoutofcampusstatisticsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					trainingbaseoutofcampusstatisticsbean.setCreatedby(user.getUserId());
				}
				qasDTrainingbaseoutofcampusstatisticsService.insert(trainingbaseoutofcampusstatisticsbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	//数据填报》基础》课程查询
	public void listcourse()throws Exception{
		if (couesebean == null) {
			couesebean = new QasDCourse();
		}
		datas = couseService.list(couesebean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》基础》课程修改和增加
	public void addcourse() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if (couesebean != null) {
			IUser user = getLoginUser();
			// 主键记录已经存在，需要进行更新操作
			if (couesebean.getId() != null && "".equals(couesebean.getId()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDCourse dsBean = couseService.select(couesebean.getId());
				if (dsBean != null) {
					if (user != null) {
						couesebean.setUpdatedby(user.getUserId());
					}
					couesebean.setId(dsBean.getId());
					couesebean.setCreatedby(dsBean.getCreatedby());
					couesebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					couseService.updateWithDyna(couesebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				} else {
					// 是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			} else {
				if (user != null) {
					couesebean.setCreatedby(user.getUserId());
				}
				couseService.insert(couesebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);

		}
	}
	
	//数据填报》基础》教工增加和修改
	public void addempoiyee() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if (empolyeebean != null) {
			IUser user = getLoginUser();
			// 主键记录已经存在，需要进行更新操作
			if (empolyeebean.getId() != null && "".equals(empolyeebean.getId()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDEmpolyee dsBean = empolyeeservice.select(empolyeebean.getId());
				if (dsBean != null) {
					if (user != null) {
						empolyeebean.setUpdatedby(user.getUserId());
					}
					empolyeebean.setId(dsBean.getId());
					empolyeebean.setCreatedby(dsBean.getCreatedby());
					empolyeebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					int rows = empolyeeservice.update(empolyeebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				} else {
					// 是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			} else {
				if (user != null) {
					empolyeebean.setCreatedby(user.getUserId());
				}
				int rows = empolyeeservice.insert(empolyeebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);

		}
	}
	
	
	
	//数据填报》基础》教工全部查询
	public void listempolyee()throws Exception{
		if (empolyeebean == null) {
			empolyeebean = new QasDEmpolyee();
		}
		datas = empolyeeservice.list(empolyeebean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》基础》班级全部查询
	public void listgrade() throws Exception {
		if(gradebean == null){ 
			gradebean = new QasDGrade();
		}
		datas = gradeservice.list(gradebean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》基础》班级增加和修改
	public void addgrade() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if (gradebean != null) {
			IUser user = getLoginUser();
			// 主键记录已经存在，需要进行更新操作
			if (gradebean.getId() != null && "".equals(gradebean.getId()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDGrade dsBean = gradeservice.select(gradebean.getId());
				if (dsBean != null) {
					if (user != null) {
						gradebean.setUpdatedby(user.getUserId());
					}
					gradebean.setId(dsBean.getId());
					gradebean.setCreatedby(dsBean.getCreatedby());
					gradebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					gradeservice.updateWithDyna(gradebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				} else {
					// 是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			} else {
				if (user != null) {
					gradebean.setCreatedby(user.getUserId());
				}
				gradeservice.insert(gradebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);

		}
	}
	
	//数据填报》基础》学生查询全部
	public void liststudent() throws Exception {
		if(studentbean == null){ 
			studentbean = new QasDStudent();
		}
		datas = studentservice.list(studentbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》基础》学生增加和修改
	public void addstudent() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(studentbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(studentbean.getId() != null && "".equals(studentbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDStudent dsBean = studentservice.select(studentbean.getId());
				if(dsBean != null){
					if (user != null) {
						studentbean.setUpdatedby(user.getUserId());
					}
					studentbean.setId(dsBean.getId());
					studentbean.setCreatedby(dsBean.getCreatedby());
					studentbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					int rows = studentservice.updateWithDyna(studentbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					studentbean.setCreatedby(user.getUserId());
				}
				int rows = studentservice.insert(studentbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》学校经费》经费支出查询全部
	public void listfundcos() throws Exception {
		if(fundcosbean == null){ 
			datas = fundcosservice.list(new HashMap());
		}else{
			datas = fundcosservice.list(fundcosbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校经费》经费支出增加和修改
	public void addfundcos() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(fundcosbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(fundcosbean.getId() != null && "".equals(fundcosbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDFundcoststatistics dsBean = fundcosservice.select(fundcosbean.getId());
				if(dsBean != null){
					if (user != null) {
						fundcosbean.setUpdatedby(user.getUserId());
					}
					fundcosbean.setId(dsBean.getId());
					fundcosbean.setCreatedby(dsBean.getCreatedby());
					fundcosbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					fundcosservice.updateWithDyna(fundcosbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					fundcosbean.setCreatedby(user.getUserId());
				}
				fundcosservice.insert(fundcosbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》学校经费》经费收入查询全部
	public void listfundincomes() throws Exception {
		// && "--请选择--".equals(bean.getSchoolincomeScope())==true
		if (fundincomesbean == null) {
			datas =fundincomesservice.list(new HashMap());
		}else{
			datas = fundincomesservice.list(fundincomesbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校经费》经费收入增加和修改
	public void addfundincomes() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if (fundincomesbean != null) {
			IUser user = getLoginUser();
			// 主键记录已经存在，需要进行更新操作
			if (fundincomesbean.getId() != null && "".equals(fundincomesbean.getId()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDFundincomestatistics dsBean = fundincomesservice.select(fundincomesbean.getId());
				if (dsBean != null) {
					if (user != null) {
						fundincomesbean.setUpdatedby(user.getUserId());
					}
					fundincomesbean.setId(dsBean.getId());
					fundincomesbean.setCreatedby(dsBean.getCreatedby());
					fundincomesbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					fundincomesservice.updateWithDyna(fundincomesbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				} else {
					// 是否需要输出数据不存在的异常

					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			} else {
				if (user != null) {
					fundincomesbean.setCreatedby(user.getUserId());
				}
				fundincomesservice.insert(fundincomesbean);
                jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);

		}
	}
	
	//数据填报》专业》产学合作查询全部
	public void listcooperate() throws Exception {
		if(cooperatebean == null){ 
			cooperatebean = new QasDCooperate();
		}
		datas = cooperateservice.list(cooperatebean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》产学合作增加和修改
	public void addcooperate() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(cooperatebean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(cooperatebean.getId() != null && "".equals(cooperatebean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDCooperate dsBean = cooperateservice.select(cooperatebean.getId());
				if(dsBean != null){
					if (user != null) {
						cooperatebean.setUpdatedby(user.getUserId());
					}
					cooperatebean.setId(dsBean.getId());
					cooperatebean.setCreatedby(dsBean.getCreatedby());
					cooperatebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					int rows = cooperateservice.updateWithDyna(cooperatebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					cooperatebean.setCreatedby(user.getUserId());
				}
				int rows = cooperateservice.insert(cooperatebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》专业》产学合作企业查询全部
	public void listcooperatecompany() throws Exception {
		if(cooperatecompanybean == null){ 
			cooperatecompanybean = new QasDCooperatecompany();
		}
		datas = cooperatecompanyservice.list(cooperatecompanybean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》产学合作企业增加和修改
	public void addcooperatecompany() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(cooperatecompanybean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(cooperatecompanybean.getId() != null && "".equals(cooperatecompanybean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDCooperatecompany dsBean = cooperatecompanyservice.select(cooperatecompanybean.getId());
				if(dsBean != null){
					if (user != null) {
						cooperatecompanybean.setUpdatedby(user.getUserId());
					}
					cooperatecompanybean.setId(dsBean.getId());
					cooperatecompanybean.setCreatedby(dsBean.getCreatedby());
					cooperatecompanybean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					cooperatecompanyservice.updateWithDyna(cooperatecompanybean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					cooperatecompanybean.setCreatedby(user.getUserId());
				}
				cooperatecompanyservice.insert(cooperatecompanybean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》课程教材》课程教材查询全部
	public void listcoursematerial() throws Exception {
		if(Coursematerialbean == null){ 
			Coursematerialbean = new QasDCoursematerial();
		}
		datas = coursematerialservice.list(Coursematerialbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》课程教材》课程教材增加和修改
	public void addcoursematerial() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Coursematerialbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Coursematerialbean.getId() != null && "".equals(Coursematerialbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDCoursematerial dsBean = coursematerialservice.select(Coursematerialbean.getId());
				if(dsBean != null){
					if (user != null) {
						Coursematerialbean.setUpdatedby(user.getUserId());
					}
					Coursematerialbean.setId(dsBean.getId());
					Coursematerialbean.setCreatedby(dsBean.getCreatedby());
					Coursematerialbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					coursematerialservice.updateWithDyna(Coursematerialbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Coursematerialbean.setCreatedby(user.getUserId());
				}
				coursematerialservice.insert(Coursematerialbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》专业方向》专业方向查询全部
	public void listdirectionstatistics() throws Exception {
		if(Directionstatisticsbean == null){ 
			Directionstatisticsbean = new QasDDirectionstatistics();
		}
		datas = directionstatisticsservice.list(Directionstatisticsbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业方向》专业方向增加和修改
	public void adddirectionstatistics() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Directionstatisticsbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Directionstatisticsbean.getId() != null && "".equals(Directionstatisticsbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDDirectionstatistics dsBean = directionstatisticsservice.select(Directionstatisticsbean.getId());
				if(dsBean != null){
					if (user != null) {
						Directionstatisticsbean.setUpdatedby(user.getUserId());
					}
					Directionstatisticsbean.setId(dsBean.getId());
					Directionstatisticsbean.setCreatedby(dsBean.getCreatedby());
					Directionstatisticsbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					directionstatisticsservice.updateWithDyna(Directionstatisticsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Directionstatisticsbean.setCreatedby(user.getUserId());
				}
				directionstatisticsservice.insert(Directionstatisticsbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》专业》应届毕业生就业统计查询全部
	public void listgraduateemployment() throws Exception {
		if(graduateemploymentbean == null){ 
			graduateemploymentbean = new QasDGraduateemployment();
		}
		datas = graduateemploymentservice.list(graduateemploymentbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》应届毕业生就业统计增加和修改
	public void addgraduateemployment() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(graduateemploymentbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(graduateemploymentbean.getId() != null && "".equals(graduateemploymentbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDGraduateemployment dsBean = graduateemploymentservice.select(graduateemploymentbean.getId());
				if(dsBean != null){
					if (user != null) {
						graduateemploymentbean.setUpdatedby(user.getUserId());
					}
					graduateemploymentbean.setId(dsBean.getId());
					graduateemploymentbean.setCreatedby(dsBean.getCreatedby());
					graduateemploymentbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					graduateemploymentservice.updateWithDyna(graduateemploymentbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					graduateemploymentbean.setCreatedby(user.getUserId());
				}
				graduateemploymentservice.insert(graduateemploymentbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》专业》应届毕业生就业单位统计查询全部
	public void listgraduateemploymentunits() throws Exception {
		if(graduateemploymentunitsbean == null){ 
			graduateemploymentunitsbean = new QasDGraduateemploymentunits();
		}
		datas = graduateemploymentunitsservice.list(graduateemploymentunitsbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》应届毕业生就业单位统计增加和修改
	public void addgraduateemploymentunits() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(graduateemploymentunitsbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(graduateemploymentunitsbean.getId() != null && "".equals(graduateemploymentunitsbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDGraduateemploymentunits dsBean = graduateemploymentunitsservice.select(graduateemploymentunitsbean.getId());
				if(dsBean != null){
					if (user != null) {
						graduateemploymentunitsbean.setUpdatedby(user.getUserId());
					}
					graduateemploymentunitsbean.setId(dsBean.getId());
					graduateemploymentunitsbean.setCreatedby(dsBean.getCreatedby());
					graduateemploymentunitsbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					graduateemploymentunitsservice.updateWithDyna(graduateemploymentunitsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					graduateemploymentunitsbean.setCreatedby(user.getUserId());
				}
				graduateemploymentunitsservice.insert(graduateemploymentunitsbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》专业》应届毕业生就业去向查询全部
	public void listgraduateinformation() throws Exception {
		if(graduateinformationbean == null){ 
			graduateinformationbean = new QasDGraduateinformation();
		}
		datas = graduateinformationservice.list(graduateinformationbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》应届毕业生就业去向增加和修改
	public void addgraduateinformation() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(graduateinformationbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(graduateinformationbean.getId() != null && "".equals(graduateinformationbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDGraduateinformation dsBean = graduateinformationservice.select(graduateinformationbean.getId());
				if(dsBean != null){
					if (user != null) {
						graduateinformationbean.setUpdatedby(user.getUserId());
					}
					graduateinformationbean.setId(dsBean.getId());
					graduateinformationbean.setCreatedby(dsBean.getCreatedby());
					graduateinformationbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					graduateinformationservice.updateWithDyna(graduateinformationbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					graduateinformationbean.setCreatedby(user.getUserId());
				}
				graduateinformationservice.insert(graduateinformationbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》专业》上届毕业生就业统计查询全部
	public void listlastyearemployment() throws Exception {
		if(lastyearemploymentbean == null){ 
			lastyearemploymentbean = new QasDLastyearemployment();
		}
		datas = lastyearemploymentservice.list(lastyearemploymentbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》上届毕业生就业统计增加和修改
	public void addlastyearemployment() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(lastyearemploymentbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(lastyearemploymentbean.getId() != null && "".equals(lastyearemploymentbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDLastyearemployment dsBean = lastyearemploymentservice.select(lastyearemploymentbean.getId());
				if(dsBean != null){
					if (user != null) {
						lastyearemploymentbean.setUpdatedby(user.getUserId());
					}
					lastyearemploymentbean.setId(dsBean.getId());
					lastyearemploymentbean.setCreatedby(dsBean.getCreatedby());
					lastyearemploymentbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					lastyearemploymentservice.updateWithDyna(lastyearemploymentbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					lastyearemploymentbean.setCreatedby(user.getUserId());
				}
				lastyearemploymentservice.insert(lastyearemploymentbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》专业》专业课程查询全部
	public void listmajorcourse() throws Exception {
		if(majorcoursebean == null){ 
			majorcoursebean = new QasDMajorcourse();
		}
		datas = majorcourseservice.list(majorcoursebean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》专业课程增加和修改
	public void addmajorcourse() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(majorcoursebean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(majorcoursebean.getId() != null && "".equals(majorcoursebean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDMajorcourse dsBean = majorcourseservice.select(majorcoursebean.getId());
				if(dsBean != null){
					if (user != null) {
						majorcoursebean.setUpdatedby(user.getUserId());
					}
					majorcoursebean.setId(dsBean.getId());
					majorcoursebean.setCreatedby(dsBean.getCreatedby());
					majorcoursebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					majorcourseservice.updateWithDyna(majorcoursebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					majorcoursebean.setCreatedby(user.getUserId());
				}
				majorcourseservice.insert(majorcoursebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》专业》专业负责人查询全部
	public void listmajorleader() throws Exception {
		if(majorleaderbean == null){ 
			majorleaderbean = new QasDMajorleader();
		}
		datas = majorleaderservice.list(majorleaderbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》专业负责人增加和修改
	public void addmajorleader() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(majorleaderbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(majorleaderbean.getId() != null && "".equals(majorleaderbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDMajorleader dsBean = majorleaderservice.select(majorleaderbean.getId());
				if(dsBean != null){
					if (user != null) {
						majorleaderbean.setUpdatedby(user.getUserId());
					}
					majorleaderbean.setId(dsBean.getId());
					majorleaderbean.setCreatedby(dsBean.getCreatedby());
					majorleaderbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					majorleaderservice.updateWithDyna(majorleaderbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					majorleaderbean.setCreatedby(user.getUserId());
				}
				majorleaderservice.insert(majorleaderbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》专业》专业定性指标查询全部
	public void listmajorqualitativeindicator() throws Exception {
		if(majorqualitativeindicatorbean == null){ 
			majorqualitativeindicatorbean = new QasDMajorqualitativeindicator();
		}
		datas = majorqualitativeindicatorservice.list(majorqualitativeindicatorbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》专业定性指标增加和修改
	public void addmajorqualitativeindicator() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(majorqualitativeindicatorbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(majorqualitativeindicatorbean.getId() != null && "".equals(majorqualitativeindicatorbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDMajorqualitativeindicator dsBean = majorqualitativeindicatorservice.select(majorqualitativeindicatorbean.getId());
				if(dsBean != null){
					if (user != null) {
						majorqualitativeindicatorbean.setUpdatedby(user.getUserId());
					}
					majorqualitativeindicatorbean.setId(dsBean.getId());
					majorqualitativeindicatorbean.setCreatedby(dsBean.getCreatedby());
					majorqualitativeindicatorbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					majorqualitativeindicatorservice.updateWithDyna(majorqualitativeindicatorbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				/*	majorqualitativeindicatorbean.setId(IDGenerator.getUUID());
					majorqualitativeindicatorservice.updateWithDyna(majorqualitativeindicatorbean);*/
				}
			}else{
				if (user != null) {
					majorqualitativeindicatorbean.setCreatedby(user.getUserId());
				}
				majorqualitativeindicatorservice.insert(majorqualitativeindicatorbean);
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》专业》定岗实习统计查询全部
	public void listpractice() throws Exception {
		if(practicebean == null){ 
			practicebean = new QasDPractice();
		}
		datas = practiceservice.list(practicebean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》定岗实习统计增加和修改
	public void addpractice() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(practicebean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(practicebean.getId() != null && "".equals(practicebean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDPractice dsBean = practiceservice.select(practicebean.getId());
				if(dsBean != null){
					if (user != null) {
						practicebean.setUpdatedby(user.getUserId());
					}
					practicebean.setId(dsBean.getId());
					practicebean.setCreatedby(dsBean.getCreatedby());
					practicebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					practiceservice.updateWithDyna(practicebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					practicebean.setCreatedby(user.getUserId());
				}
				practiceservice.insert(practicebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》专业》招生计划查询全部
	public void listrecruit() throws Exception {
		if(recruitbean == null){ 
			recruitbean = new QasDRecruit();
		}
		datas = recruitservice.list(recruitbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》专业》招生计划增加和修改
	public void addrecruit() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(recruitbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(recruitbean.getId() != null && "".equals(recruitbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDRecruit dsBean = recruitservice.select(recruitbean.getId());
				if(dsBean != null){
					if (user != null) {
						recruitbean.setUpdatedby(user.getUserId());
					}
					recruitbean.setId(dsBean.getId());
					recruitbean.setCreatedby(dsBean.getCreatedby());
					recruitbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					recruitservice.updateWithDyna(recruitbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					recruitbean.setCreatedby(user.getUserId());
				}
				recruitservice.insert(recruitbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》占地面积查询全部
	public void listareaofstructure() throws Exception {
		if(areaofstructurebean == null){ 
			datas = areaofstructureservice.list(new HashMap());
		}else{
			datas = areaofstructureservice.list(areaofstructurebean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》占地面积增加和修改
	public void addareaofstructure() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if (areaofstructurebean != null) {
			IUser user = getLoginUser();
			// 主键记录已经存在，需要进行更新操作
			if (areaofstructurebean.getId() != null && "".equals(areaofstructurebean.getId()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDAreaofstructure dsBean = areaofstructureservice.select(areaofstructurebean.getId());
				if (dsBean != null) {
					if (user != null) {
						areaofstructurebean.setUpdatedby(user.getUserId());
					}
					areaofstructurebean.setId(dsBean.getId());
					areaofstructurebean.setCreatedby(dsBean.getCreatedby());
					areaofstructurebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					areaofstructureservice.updateWithDyna(areaofstructurebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				} else {
					// 是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			} else {
				if (user != null) {
					areaofstructurebean.setCreatedby(user.getUserId());
				}
				areaofstructureservice.insert(areaofstructurebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》馆藏图书统计查询全部
	public void listbooksinlibrary() throws Exception {
		if(booksinlibrarybean == null){ 
			datas = booksinlibraryservice.list(new HashMap());
		}else{
			datas = booksinlibraryservice.list(booksinlibrarybean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》馆藏图书统计增加和修改
	public void addbooksinlibrary() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(booksinlibrarybean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(booksinlibrarybean.getId() != null && "".equals(booksinlibrarybean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDBooksinlibrary dsBean = booksinlibraryservice.select(booksinlibrarybean.getId());
				if(dsBean != null){
					if (user != null) {
						booksinlibrarybean.setUpdatedby(user.getUserId());
					}
					booksinlibrarybean.setId(dsBean.getId());
					booksinlibrarybean.setCreatedby(dsBean.getCreatedby());
					booksinlibrarybean.setCreatedtime(dsBean.getCreatedtime());
				// 如果数据库中有此记录信息，进行更新操作
					booksinlibraryservice.updateWithDyna(booksinlibrarybean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					booksinlibrarybean.setCreatedby(user.getUserId());
				}
				booksinlibraryservice.insert(booksinlibrarybean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》全日制高职招生计划查询全部
	public void listcollegeenrolplan() throws Exception {
		if(collegeenrolplanbean == null){ 
			datas = collegeenrolplanservice.list(new HashMap());
		}else{
			datas = collegeenrolplanservice.list(collegeenrolplanbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》全日制高职招生计划增加和修改
	public void addcollegeenrolplan() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(collegeenrolplanbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(collegeenrolplanbean.getId() != null && "".equals(collegeenrolplanbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDCollegeenrolplan dsBean = collegeenrolplanservice.select(collegeenrolplanbean.getId());
				if(dsBean != null){
					if (user != null) {
						collegeenrolplanbean.setUpdatedby(user.getUserId());
					}
					collegeenrolplanbean.setId(dsBean.getId());
					collegeenrolplanbean.setCreatedby(dsBean.getCreatedby());
					collegeenrolplanbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					collegeenrolplanservice.updateWithDyna(collegeenrolplanbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					collegeenrolplanbean.setCreatedby(user.getUserId());
				}
				collegeenrolplanservice.insert(collegeenrolplanbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》全日制高职招生方式全部查询
	public void listcollegeenroltype() throws Exception {
		if(collegeenroltypebean == null){ 
			datas = collegeenroltypeservice.list(new HashMap());
		}else{
			datas = collegeenroltypeservice.list(collegeenroltypebean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》全日制高职招生方式增加和修改
	public void addcollegeenroltype() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(collegeenroltypebean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(collegeenroltypebean.getId() != null && "".equals(collegeenroltypebean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDCollegeenroltype dsBean = collegeenroltypeservice.select(collegeenroltypebean.getId());
				if(dsBean != null){
					if (user != null) {
						collegeenroltypebean.setUpdatedby(user.getUserId());
					}
					collegeenroltypebean.setId(dsBean.getId());
					collegeenroltypebean.setCreatedby(dsBean.getCreatedby());
					collegeenroltypebean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					collegeenroltypeservice.updateWithDyna(collegeenroltypebean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					collegeenroltypebean.setCreatedby(user.getUserId());
				}
				collegeenroltypeservice.insert(collegeenroltypebean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》院校在校生统计查询全部
	public void listcollegeinschoolstudent() throws Exception {
		if(collegeinschoolstudentbean == null){ 
			datas = collegeinschoolstudentservice.list(new HashMap());
		}else{
			datas = collegeinschoolstudentservice.list(collegeinschoolstudentbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》院校在校生统计增加和修改
	public void addcollegeinschoolstudent() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(collegeinschoolstudentbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(collegeinschoolstudentbean.getId() != null && "".equals(collegeinschoolstudentbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDCollegeinschoolstudent dsBean = collegeinschoolstudentservice.select(collegeinschoolstudentbean.getId());
				if(dsBean != null){
					if (user != null) {
						collegeinschoolstudentbean.setUpdatedby(user.getUserId());
					}
					collegeinschoolstudentbean.setId(dsBean.getId());
					collegeinschoolstudentbean.setCreatedby(dsBean.getCreatedby());
					collegeinschoolstudentbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					int rows = collegeinschoolstudentservice.updateWithDyna(collegeinschoolstudentbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					collegeinschoolstudentbean.setCreatedby(user.getUserId());
				}
				int rows = collegeinschoolstudentservice.insert(collegeinschoolstudentbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》院校联系信息》查询全部
	public void listschoolcontacter() throws Exception {
		if(schoolcontacterbean == null){ 
			schoolcontacterbean = new QasDSchoolcontacter();
		}
		datas = schoolcontacterservice.list(schoolcontacterbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》院校联系信息》增加和修改
	public void addschoolcontacter() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(schoolcontacterbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(schoolcontacterbean.getId() != null && "".equals(schoolcontacterbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDSchoolcontacter dsBean = schoolcontacterservice.select(schoolcontacterbean.getId());
				if(dsBean != null){
					if (user != null) {
						schoolcontacterbean.setUpdatedby(user.getUserId());
					}
					schoolcontacterbean.setId(dsBean.getId());
					schoolcontacterbean.setCreatedby(dsBean.getCreatedby());
					schoolcontacterbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					schoolcontacterservice.updateWithDyna(schoolcontacterbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					schoolcontacterbean.setCreatedby(user.getUserId());
				}
				schoolcontacterservice.insert(schoolcontacterbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》固定资产》查询全部
	public void listfixedassets() throws Exception {
		if(fixedassetsbean == null){ 
			datas = fixedassetsservice.list(new HashMap());
		}else{
			datas = fixedassetsservice.list(fixedassetsbean);
		}	
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》固定资产》增加和修改
	public void addfixedassets() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(fixedassetsbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(fixedassetsbean.getId() != null && "".equals(fixedassetsbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDFixedassets dsBean = fixedassetsservice.select(fixedassetsbean.getId());
				if(dsBean != null){
					if (user != null) {
						fixedassetsbean.setUpdatedby(user.getUserId());
					}
					fixedassetsbean.setId(dsBean.getId());
					fixedassetsbean.setCreatedby(dsBean.getCreatedby());
					fixedassetsbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					fixedassetsservice.updateWithDyna(fixedassetsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					fixedassetsbean.setCreatedby(user.getUserId());
				}
				fixedassetsservice.insert(fixedassetsbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
			
		}
	}
	
	//数据填报》学校》信息化建设》查询全部
	public void listInformationconstruction() throws Exception {
		if(Informationconstructionbean == null){ 
			datas = Informationconstructionservice.list(new HashMap());
		}else{
			datas = Informationconstructionservice.list(Informationconstructionbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》信息化建设》增加和修改
	public void addInformationconstruction() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Informationconstructionbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Informationconstructionbean.getId() != null && "".equals(Informationconstructionbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDInformationconstruction dsBean = Informationconstructionservice.select(Informationconstructionbean.getId());
				if(dsBean != null){
					if (user != null) {
						Informationconstructionbean.setUpdatedby(user.getUserId());
					}
					Informationconstructionbean.setId(dsBean.getId());
					Informationconstructionbean.setCreatedby(dsBean.getCreatedby());
					Informationconstructionbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Informationconstructionservice.updateWithDyna(Informationconstructionbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Informationconstructionbean.setCreatedby(user.getUserId());
				}
				Informationconstructionservice.insert(Informationconstructionbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》领导参与教学》查询全部
	public void listLeaderaction() throws Exception {
		if(Leaderactionbean == null){ 
			datas = Leaderactionservice.list(new HashMap());
		}else{
			datas = Leaderactionservice.list(Leaderactionbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》领导参与教学》增加和修改
	public void addLeaderaction() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Leaderactionbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Leaderactionbean.getId() != null && "".equals(Leaderactionbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDLeaderaction dsBean = Leaderactionservice.select(Leaderactionbean.getId());
				if(dsBean != null){
					if (user != null) {
						Leaderactionbean.setUpdatedby(user.getUserId());
					}
					Leaderactionbean.setId(dsBean.getId());
					Leaderactionbean.setCreatedby(dsBean.getCreatedby());
					Leaderactionbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					int rows = Leaderactionservice.updateWithDyna(Leaderactionbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Leaderactionbean.setCreatedby(user.getUserId());
				}
				int rows = Leaderactionservice.insert(Leaderactionbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》管理信息系统》查询全部
	public void listManagementinformationsystem() throws Exception {
		if(Managementinformationsystembean == null){ 
			Managementinformationsystembean = new QasDManagementinformationsystem();
		}
		datas = Managementinformationsystemservice.list(Managementinformationsystembean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》管理信息系统》增加和修改
	public void addManagementinformationsystem() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Managementinformationsystembean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Managementinformationsystembean.getId() != null && "".equals(Managementinformationsystembean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDManagementinformationsystem dsBean = Managementinformationsystemservice.select(Managementinformationsystembean.getId());
				if(dsBean != null){
					if (user != null) {
						Managementinformationsystembean.setUpdatedby(user.getUserId());
					}
					Managementinformationsystembean.setId(dsBean.getId());
					Managementinformationsystembean.setCreatedby(dsBean.getCreatedby());
					Managementinformationsystembean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Managementinformationsystemservice.updateWithDyna(Managementinformationsystembean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Managementinformationsystembean.setCreatedby(user.getUserId());
				}
				Managementinformationsystemservice.insert(Managementinformationsystembean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》组织机构》查询全部
	public void listOrganizationstatistics() throws Exception {
		if(Organizationstatisticsbean == null){ 
			datas = Organizationstatisticsservice.list(new HashMap());
		}else{
			datas = Organizationstatisticsservice.list(Organizationstatisticsbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》组织机构》增加和修改
	public void addOrganizationstatistics() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Organizationstatisticsbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Organizationstatisticsbean.getId() != null && "".equals(Organizationstatisticsbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDOrganizationstatistics dsBean = Organizationstatisticsservice.select(Organizationstatisticsbean.getId());
				if(dsBean != null){
					if (user != null) {
						Organizationstatisticsbean.setUpdatedby(user.getUserId());
					}
					Organizationstatisticsbean.setId(dsBean.getId());
					Organizationstatisticsbean.setCreatedby(dsBean.getCreatedby());
					Organizationstatisticsbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Organizationstatisticsservice.updateWithDyna(Organizationstatisticsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Organizationstatisticsbean.setCreatedby(user.getUserId());
				}
				Organizationstatisticsservice.insert(Organizationstatisticsbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》校内实践基地属性》查询全部
	public void listPracticebaseincampus() throws Exception {
		if(Practicebaseincampusbean == null){ 
			datas = Practicebaseincampusservice.list(new HashMap());
		}else{
			datas = Practicebaseincampusservice.list(Practicebaseincampusbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》校内实践基地属性》增加和修改
	public void addPracticebaseincampus() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Practicebaseincampusbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Practicebaseincampusbean.getId() != null && "".equals(Practicebaseincampusbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDPracticebaseincampus dsBean = Practicebaseincampusservice.select(Practicebaseincampusbean.getId());
				if(dsBean != null){
					if (user != null) {
						Practicebaseincampusbean.setUpdatedby(user.getUserId());
					}
					Practicebaseincampusbean.setId(dsBean.getId());
					Practicebaseincampusbean.setCreatedby(dsBean.getCreatedby());
					Practicebaseincampusbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Practicebaseincampusservice.updateWithDyna(Practicebaseincampusbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Practicebaseincampusbean.setCreatedby(user.getUserId());
				}
				Practicebaseincampusservice.insert(Practicebaseincampusbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》校内实践基地统计》查询全部
	public void listPracticebaseincampusstatistics() throws Exception {
		if(Practicebaseincampusstatisticsbean == null){ 
			datas = Practicebaseincampusstatisticsservice.list(new HashMap());
		}else{
			datas = Practicebaseincampusstatisticsservice.list(Practicebaseincampusstatisticsbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》校内实践基地统计》增加和修改
	public void addPracticebaseincampusstatistics() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Practicebaseincampusstatisticsbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Practicebaseincampusstatisticsbean.getId() != null && "".equals(Practicebaseincampusstatisticsbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDPracticebaseincampusstatistics dsBean = Practicebaseincampusstatisticsservice.select(Practicebaseincampusstatisticsbean.getId());
				if(dsBean != null){
					if (user != null) {
						Practicebaseincampusstatisticsbean.setUpdatedby(user.getUserId());
					}
					Practicebaseincampusstatisticsbean.setId(dsBean.getId());
					Practicebaseincampusstatisticsbean.setCreatedby(dsBean.getCreatedby());
					Practicebaseincampusstatisticsbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Practicebaseincampusstatisticsservice.updateWithDyna(Practicebaseincampusstatisticsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Practicebaseincampusstatisticsbean.setCreatedby(user.getUserId());
				}
				Practicebaseincampusstatisticsservice.insert(Practicebaseincampusstatisticsbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》阅览室，机房，教室》查询全部
	public void listRooms() throws Exception {
		if(Roomsbean == null){ 
			datas = Roomsservice.list(new HashMap());
		}else{
			datas = Roomsservice.list(Roomsbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》阅览室，机房，教室》增加和修改
	public void addRooms() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Roomsbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Roomsbean.getId() != null && "".equals(Roomsbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDRooms dsBean = Roomsservice.select(Roomsbean.getId());
				if(dsBean != null){
					if (user != null) {
						Roomsbean.setUpdatedby(user.getUserId());
					}
					Roomsbean.setId(dsBean.getId());
					Roomsbean.setCreatedby(dsBean.getCreatedby());
					Roomsbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Roomsservice.updateWithDyna(Roomsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Roomsbean.setCreatedby(user.getUserId());
				}
				Roomsservice.insert(Roomsbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》院校》查询全部
	public void listSchool() throws Exception {
		if (Schoolbean == null) {
			Schoolbean = new QasDSchool();
		}
		datas = Schoolservice.list(Schoolbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》院校》增加和修改
	public void addSchool() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if (Schoolbean != null) {
			IUser user = getLoginUser();
			// 主键记录已经存在，需要进行更新操作
			if (Schoolbean.getId() != null && "".equals(Schoolbean.getId()) == false) {
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDSchool dsBean = Schoolservice.select(Schoolbean.getId());
				if (dsBean != null) {
					if (user != null) {
						Schoolbean.setUpdatedby(user.getUserId());
					}
					Schoolbean.setId(dsBean.getId());
					Schoolbean.setCreatedby(dsBean.getCreatedby());
					Schoolbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Schoolservice.update(Schoolbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				} else {
					// 是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			} else {
				if (user != null) {
					Schoolbean.setCreatedby(user.getUserId());
				}
				Schoolservice.insert(Schoolbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》学校获奖情况》全部查询
	public void listShoolaward() throws Exception {
		if(Shoolawardbean == null){ 
			Shoolawardbean = new QasDShoolaward();
		}
		datas = Shoolawardservice.list(Shoolawardbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》学校获奖情况》增加和修改
	public void addShoolaward() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Shoolawardbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Shoolawardbean.getId() != null && "".equals(Shoolawardbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDShoolaward dsBean = Shoolawardservice.select(Shoolawardbean.getId());
				if(dsBean != null){
					if (user != null) {
						Shoolawardbean.setUpdatedby(user.getUserId());
					}
					Shoolawardbean.setId(dsBean.getId());
					Shoolawardbean.setCreatedby(dsBean.getCreatedby());
					Shoolawardbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Shoolawardservice.updateWithDyna(Shoolawardbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Shoolawardbean.setCreatedby(user.getUserId());
				}
				Shoolawardservice.insert(Shoolawardbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》职业技能鉴定机构》全部查询
	public void listSkillappraisalorg() throws Exception {
		if(Skillappraisalorgbean == null){ 
			Skillappraisalorgbean = new QasDSkillappraisalorg();
		}
		datas = Skillappraisalorgservice.list(Skillappraisalorgbean);
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》职业技能鉴定机构》全部查询
	public void addSkillappraisalorg() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Skillappraisalorgbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Skillappraisalorgbean.getId() != null && "".equals(Skillappraisalorgbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDSkillappraisalorg dsBean = Skillappraisalorgservice.select(Skillappraisalorgbean.getId());
				if(dsBean != null){
					if (user != null) {
						Skillappraisalorgbean.setUpdatedby(user.getUserId());
					}
					Skillappraisalorgbean.setId(dsBean.getId());
					Skillappraisalorgbean.setCreatedby(dsBean.getCreatedby());
					Skillappraisalorgbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Skillappraisalorgservice.updateWithDyna(Skillappraisalorgbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Skillappraisalorgbean.setCreatedby(user.getUserId());
				}
				Skillappraisalorgservice.insert(Skillappraisalorgbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》职业技能鉴定机构统计》全部查询
	public void listSkillappraisalorgstatistics() throws Exception {
		if(Skillappraisalorgstatisticsbean == null){ 
			datas = Skillappraisalorgstatisticsservice.list(new HashMap());
		}else{
			datas = Skillappraisalorgstatisticsservice.list(Skillappraisalorgstatisticsbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》职业技能鉴定机构统计统计》修改和增加
	public void addSkillappraisalorgstatistics() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Skillappraisalorgstatisticsbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Skillappraisalorgstatisticsbean.getId() != null && "".equals(Skillappraisalorgstatisticsbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDSkillappraisalorgstatistics dsBean = Skillappraisalorgstatisticsservice.select(Skillappraisalorgstatisticsbean.getId());
				if(dsBean != null){
					if (user != null) {
						Skillappraisalorgstatisticsbean.setUpdatedby(user.getUserId());
					}
					Skillappraisalorgstatisticsbean.setId(dsBean.getId());
					Skillappraisalorgstatisticsbean.setCreatedby(dsBean.getCreatedby());
					Skillappraisalorgstatisticsbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					int rows = Skillappraisalorgstatisticsservice.updateWithDyna(Skillappraisalorgstatisticsbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Skillappraisalorgstatisticsbean.setCreatedby(user.getUserId());
				}
				int rows = Skillappraisalorgstatisticsservice.insert(Skillappraisalorgstatisticsbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
	
	//数据填报》学校》社会准捐款情况》查询全部
	public void listSocialdonation() throws Exception {
		if(Socialdonationbean == null){ 
			datas = Socialdonationservice.list(new HashMap());
		}else{
			datas = Socialdonationservice.list(Socialdonationbean);
		}
		response.setContentType("text/json; charset=UTF-8");
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//数据填报》学校》社会准捐款情况》修改和增加
	public void addSocialdonation() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(Socialdonationbean != null  ){
			IUser user = getLoginUser();
			//主键记录已经存在，需要进行更新操作
			if(Socialdonationbean.getId() != null && "".equals(Socialdonationbean.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasDSocialdonation dsBean = Socialdonationservice.select(Socialdonationbean.getId());
				if(dsBean != null){
					if (user != null) {
						Socialdonationbean.setUpdatedby(user.getUserId());
					}
					Socialdonationbean.setId(dsBean.getId());
					Socialdonationbean.setCreatedby(dsBean.getCreatedby());
					Socialdonationbean.setCreatedtime(dsBean.getCreatedtime());
					// 如果数据库中有此记录信息，进行更新操作
					Socialdonationservice.updateWithDyna(Socialdonationbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				if (user != null) {
					Socialdonationbean.setCreatedby(user.getUserId());
				}
				Socialdonationservice.insert(Socialdonationbean);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			if(jstr == null){
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
			}
				response.getWriter().print(jstr);
		}
	}
		
		//数据填报》学校》校外实习基地属性》查询全部
		public void listTrainingbaseoutofcampus() throws Exception {
			if(Trainingbaseoutofcampusbean == null){ 
				Trainingbaseoutofcampusbean = new QasDTrainingbaseoutofcampus();
			}
			datas = Trainingbaseoutofcampusservice.list(Trainingbaseoutofcampusbean);
			response.setContentType("text/json; charset=UTF-8");
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
		
		//数据填报》学校》校外实习基地属性》增加和修改
		public void addTrainingbaseoutofcampus() throws Exception {
			response.setContentType("text/json; charset=UTF-8");
			String jstr = null;
			if(Trainingbaseoutofcampusbean != null  ){
				IUser user = getLoginUser();
				//主键记录已经存在，需要进行更新操作
				if(Trainingbaseoutofcampusbean.getId() != null && "".equals(Trainingbaseoutofcampusbean.getId()) == false){
					// dsBean 数据库中的记录 此ID是否在数据库中存在
					QasDTrainingbaseoutofcampus dsBean = Trainingbaseoutofcampusservice.select(Trainingbaseoutofcampusbean.getId());
					if(dsBean != null){
						if (user != null) {
							Trainingbaseoutofcampusbean.setUpdatedby(user.getUserId());
						}
						Trainingbaseoutofcampusbean.setId(dsBean.getId());
						Trainingbaseoutofcampusbean.setCreatedby(dsBean.getCreatedby());
						Trainingbaseoutofcampusbean.setCreatedtime(dsBean.getCreatedtime());
						// 如果数据库中有此记录信息，进行更新操作
						Trainingbaseoutofcampusservice.updateWithDyna(Trainingbaseoutofcampusbean);
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("更新成功", null), "yyyy-MM-dd HH:mm:ss");
					}else{
						//是否需要输出数据不存在的异常
						jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("数据不存在",null), "yyyy-MM-dd HH:mm:ss");
					}
				}else{
					if (user != null) {
						Trainingbaseoutofcampusbean.setCreatedby(user.getUserId());
					}
					Trainingbaseoutofcampusservice.insert(Trainingbaseoutofcampusbean);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("新增成功", null), "yyyy-MM-dd HH:mm:ss");
				}
				if(jstr == null){
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
				}
					response.getWriter().print(jstr);
			}
		}
	//获取诊断报告-->全部列表信息(查询已发布的所有信息)
	public void listDiagnosetask() throws Exception {
		if(diagnosetask == null){ 
			diagnosetask = new QasTDiagnosetask();
		}
		//diagnosetask.setPublishstatus(0);    //这里应该不用设置，查询全部呀应该包括没发布的，这里后期再说
		datas = diagnosetaskService.list(diagnosetask);
		response.setContentType("text/json; charset=UTF-8");
        String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
        response.getWriter().print(jstr);
	}

	//查询诊断指标中一起获得要素和诊断点
	public void getIndicatorcatalogType() throws Exception {
		String parentid = request.getParameter("parentid");
		String indicatortypeString = request.getParameter("indicatortype");	
		List resultList = new ArrayList();
		Integer indicatortype = null;
		if(indicatortypeString != null && indicatortypeString.matches("\\d+")){
			indicatortype = Integer.valueOf(indicatortypeString);
		}
		response.setContentType("text/json; charset=UTF-8");
		datas = decAandroidService.getIndicatorcatalogTypeMapper(indicatortype, parentid);
		for (Object res : datas) {
			QasTIndicatorcatalog map = (QasTIndicatorcatalog)res;
			List list = new ArrayList();
			Map<String, Object> parems = new HashMap<String, Object>();
			parems.put("parentid", map.getId());
			list = qasTIndicatorcatalogMapper.queryParams(parems);
			DataReportingMenuBean dataReportingMenuBean = new DataReportingMenuBean();
			dataReportingMenuBean.setRankOne(res);
			dataReportingMenuBean.setRankTwo(list);
			resultList.add(dataReportingMenuBean);
		}
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(resultList), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//查询诊断指标目录
	public void getIndicatorcatalogTree() throws Exception {
		String parentid = request.getParameter("parentid");
		String indicatortypeString = request.getParameter("indicatortype");
		Integer indicatortype = null;
		if(indicatortypeString != null && indicatortypeString.matches("\\d+")){
			indicatortype = Integer.valueOf(indicatortypeString);
		}
		response.setContentType("text/json; charset=UTF-8");
		datas = decAandroidService.getIndicatorcatalogTypeMapper(indicatortype, parentid);
		String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(datas), "yyyy-MM-dd HH:mm:ss");
		response.getWriter().print(jstr);
	}
	
	//查询指标详情
	public void getIndicatorcatalogInfo() throws IOException{
		if(qasTIndicatorcatalogBean != null && qasTIndicatorcatalogBean.getId() != null && "".equals(qasTIndicatorcatalogBean.getId()) == false){
			Map<String,Object> result=new HashMap<String, Object>();
			QasTIndicatorcontent list= indicatorcontentservice.select(qasTIndicatorcatalogBean.getId());
			QasTIndicatorcatalogextend listextend=indicatorcontentservice.selectextend(qasTIndicatorcatalogBean.getId());
			result.put("bean", list);
			result.put("exten", listextend);
			response.setContentType("text/json; charset=UTF-8");
			//JSONObject json = JSONObject.fromObject(result);
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(result), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
			}
	}
	
	//诊断任务详情查询
	public void getDiagnosetaskInfo() throws IOException{
		Map resultMap = new HashMap();
		if(diagnosetask != null && diagnosetask.getId() != null && "".equals(diagnosetask.getId()) == false){
			diagnosetask = diagnosetaskService.select(diagnosetask.getId());
			diagnosetasklevels = diagnosetaskService.selectLevels(diagnosetask.getId());
			diagnosetaskdates = diagnosetaskService.selectDatas(diagnosetask.getId());
			diagnosetaskobjlist = diagnosetaskService.selectfind(diagnosetask.getId());
			diagnosescheme =  diagnoseschemeService.select(diagnosetask.getSchemeid());
			resultMap.put("diagnosetask", diagnosetask);
			resultMap.put("diagnosetasklevels", diagnosetasklevels);
			resultMap.put("diagnosetaskdates", diagnosetaskdates);
			resultMap.put("diagnosetaskobjlist", diagnosetaskobjlist);
			resultMap.put("diagnosescheme", diagnosescheme);
			/*diagnosescheme = diagnosetaskService.selectcheme(diagnosetask.getSchemeid());*/
			if (diagnosetaskobj == null) {
				diagnosetaskobj = new QasTDiagnosetaskobj();
			}
			String taskobj="";
			String taskobjid="";
			
			for(QasTDiagnosetaskobj objid:diagnosetaskobjlist){
				taskobjid = objid.getDiagnoseobjid()+","+taskobjid;
			}
			for(QasTDiagnosetaskobj obj:diagnosetaskobjlist){
				taskobj = obj.getDiagnoseobjname()+","+taskobj;
			}
			taskobjid = StringUtils.substringBeforeLast(taskobjid,",");
			diagnosetaskobj.setDiagnoseobjid(taskobjid);
			taskobj = StringUtils.substringBeforeLast(taskobj,",");
			diagnosetaskobj.setDiagnoseobjname(taskobj);
			resultMap.put("diagnosetaskobj",diagnosetaskobj );
			/*diagnosescheme =  diagnoseschemeService.select(diagnosetask.getSchemeid());*///查询关联模型类型
			if(diagnosescheme != null){
				//request.setAttribute("type", diagnosescheme.getRangetype());
				resultMap.put("type", diagnosescheme.getRangetype());
			}
			
			response.setContentType("text/json; charset=UTF-8");
			//JSONObject json = JSONObject.fromObject(result);
			String jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(resultMap), "yyyy-MM-dd HH:mm:ss");
			response.getWriter().print(jstr);
		}
	}
	
	//诊断任务的--新增和动态更新操作
	public void addDiagnosetask() throws IOException{
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(diagnosetask != null  ){
			//主键记录已经存在，需要进行更新操作
			IUser user = getLoginUser();
			if(diagnosetask.getId() != null && "".equals(diagnosetask.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasTDiagnosetask dsBean = diagnosetaskService.select(diagnosetask.getId());
				if(dsBean != null){
					// 如果数据库中有此记录信息，进行更新操作
					//int rows = service.update(bean);
					diagnosetask.setUpdatedby(user.getUserId());
					diagnosetask.setUpdatedtime(new Date());
					diagnosetaskService.updateWithDyna(diagnosetask,diagnosetasklevels,diagnosetaskdates,diagnosetaskobj);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("修改成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要修改的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
			}else{
				diagnosetask.setCreatedby(user.getUserId());
				diagnosetask.setCreatedtime(new Date());
				diagnosetask.setUpdatedby(user.getUserId());
				diagnosetask.setUpdatedtime(new Date());
				diagnosetaskService.insert(diagnosetask,diagnosetasklevels,diagnosetaskdates,diagnosetaskobj);
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("添加成功", null), "yyyy-MM-dd HH:mm:ss");
			}
			
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	//诊断任务发布
	public void addPublish() throws Exception {
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(diagnosetask != null  ){
			//主键记录已经存在，需要进行更新操作
			IUser user = getLoginUser();
			if(diagnosetask.getId() != null && "".equals(diagnosetask.getId()) == false){
				// dsBean 数据库中的记录 此ID是否在数据库中存在
				QasTDiagnosetask dsBean = diagnosetaskService.select(diagnosetask.getId());
				if(dsBean != null){
					// 如果数据库中有此记录信息，进行更新操作
					//int rows = service.update(bean);
					diagnosetask.setUpdatedby(user.getUserId());
					diagnosetask.setSchemeid(dsBean.getSchemeid());
					diagnosetask.setUpdatedtime(new Date());
					diagnosetask.setPublishtime(new Date());
					diagnosetask.setPublishstatus(1);//已发布状态
					diagnosetaskService.updateWithDyna(diagnosetask);
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResultsSetMsg("发布成功", null), "yyyy-MM-dd HH:mm:ss");
				}else{
					//是否需要输出数据不存在的异常
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("你要发布的数据不存在",null), "yyyy-MM-dd HH:mm:ss");
				}
				
				}
				response.getWriter().print(jstr);
			}
		}
	
	
	//诊断任务的删除
	public void removeDiagnosetask() throws IOException{
//		ResultMap result = new ResultMap();
		response.setContentType("text/json; charset=UTF-8");
		String jstr = null;
		if(diagnosetask != null && diagnosetask.getId() != null){
//			String idArrs[] = diagnosetask.getId().split("[,]");
			boolean checkResult = true;
//程序是否需要对此数据进行数据检验,如果是请开启此部分的数据检验			
//			for(int i = 0 ; i < idArrs.length ; i++){
//					//是否有对应的数据存在
//					int rows = Integer.valueOf(((Map)service.get2Object("查询数据的行数", bean)).get("CNUM").toString());
//					if(rows > 0){
//						checkResult = false;
//						break;
//					}
//			}	
			if(checkResult == true){
				try{
					int rows = diagnosetaskService.delete((Object)diagnosetask.getId());
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getSuccessfulResults(null), "yyyy-MM-dd HH:mm:ss");
				}catch(Exception e){
					e.printStackTrace();
					jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults(e.getMessage(),null), "yyyy-MM-dd HH:mm:ss");
					//result.put("message", e.getMessage());
				}
			}else{
				//result.setSuccess(false);
				//result.setMsg("已经存在相关联的数据，请先删除");
				jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("已经存在相关联的数据，请先删除",null), "yyyy-MM-dd HH:mm:ss");
			}
		}else{
			//result.put("message","错误参数");
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResults("错误参数",null), "yyyy-MM-dd HH:mm:ss");
		}
		if(jstr == null){
			jstr = JSON.toJSONStringWithDateFormat(ResultSet.getFailResultsDefaultMsg(null), "yyyy-MM-dd HH:mm:ss");
		}
		response.getWriter().print(jstr);
	}
	
	/**
	 * 获取诊断报告详情---搁置
	 */
	public void queryInfoDiagnoseObj() throws Exception{
		ResultMap result = new ResultMap();
		String diagnosetaskid = request.getParameter("diagnosetaskid");
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		diagnosticreport = new QasTDiagnosticreport();
		diagnosticreport.setDiagnosetaskid(diagnosetaskid);
		list = diagnosticreportService.select(diagnosticreport);
		result.setObj(list);
		response.setContentType("text/json; charset=UTF-8");
		response.getWriter().print(result.getJsonStr());
	}
	
	
	
	
		
	
	
	
	
	public QasDStudregioninfo getStudregioninfobean() {
		return studregioninfobean;
	}

	public void setStudregioninfobean(QasDStudregioninfo studregioninfobean) {
		this.studregioninfobean = studregioninfobean;
	}

	public QasDStudentnormal getStudentnormalbean() {
		return studentnormalbean;
	}

	public void setStudentnormalbean(QasDStudentnormal studentnormalbean) {
		this.studentnormalbean = studentnormalbean;
	}

	public QasDStudentaward getStudentawardbean() {
		return studentawardbean;
	}

	public void setStudentawardbean(QasDStudentaward studentawardbean) {
		this.studentawardbean = studentawardbean;
	}

	public QasDStudassociationstatistics getStudassociationstatisticsbean() {
		return studassociationstatisticsbean;
	}

	public void setStudassociationstatisticsbean(
			QasDStudassociationstatistics studassociationstatisticsbean) {
		this.studassociationstatisticsbean = studassociationstatisticsbean;
	}

	public QasDStudassociation getStudassociationbean() {
		return studassociationbean;
	}

	public void setStudassociationbean(QasDStudassociation studassociationbean) {
		this.studassociationbean = studassociationbean;
	}

	public QasDSkilltraining getSkilltrainingbean() {
		return skilltrainingbean;
	}

	public void setSkilltrainingbean(QasDSkilltraining skilltrainingbean) {
		this.skilltrainingbean = skilltrainingbean;
	}

	public QasDRetiredsoldiers getRetiredsoldiersbean() {
		return retiredsoldiersbean;
	}

	public void setRetiredsoldiersbean(QasDRetiredsoldiers retiredsoldiersbean) {
		this.retiredsoldiersbean = retiredsoldiersbean;
	}

	public QasDQualification getQualificationbean() {
		return qualificationbean;
	}

	public void setQualificationbean(QasDQualification qualificationbean) {
		this.qualificationbean = qualificationbean;
	}

	public QasDDropoutlist getDropoutlistbean() {
		return dropoutlistbean;
	}

	public void setDropoutlistbean(QasDDropoutlist dropoutlistbean) {
		this.dropoutlistbean = dropoutlistbean;
	}

	public QasDAssociationandredcrossaward getRedcrossawardbean() {
		return redcrossawardbean;
	}

	public void setRedcrossawardbean(
			QasDAssociationandredcrossaward redcrossawardbean) {
		this.redcrossawardbean = redcrossawardbean;
	}

	public QasDTeacheraward getTeacherawardbean() {
		return teacherawardbean;
	}

	public void setTeacherawardbean(QasDTeacheraward teacherawardbean) {
		this.teacherawardbean = teacherawardbean;
	}

	public QasDTeachingresource getTeachingresourcebean() {
		return teachingresourcebean;
	}

	public void setTeachingresourcebean(QasDTeachingresource teachingresourcebean) {
		this.teachingresourcebean = teachingresourcebean;
	}

	public QasDTeachertraining getTeachertrainingbean() {
		return teachertrainingbean;
	}

	public void setTeachertrainingbean(QasDTeachertraining teachertrainingbean) {
		this.teachertrainingbean = teachertrainingbean;
	}

	public QasDTeachertechnicalmonopoly getChnicalmonopolybean() {
		return chnicalmonopolybean;
	}

	public void setChnicalmonopolybean(
			QasDTeachertechnicalmonopoly chnicalmonopolybean) {
		this.chnicalmonopolybean = chnicalmonopolybean;
	}

	public QasDTeacherteachingtrain getTeacherteachingtrainbean() {
		return teacherteachingtrainbean;
	}

	public void setTeacherteachingtrainbean(
			QasDTeacherteachingtrain teacherteachingtrainbean) {
		this.teacherteachingtrainbean = teacherteachingtrainbean;
	}

	public QasDTeachersecondment getTeachersecondmentbean() {
		return teachersecondmentbean;
	}

	public void setTeachersecondmentbean(QasDTeachersecondment teachersecondmentbean) {
		this.teachersecondmentbean = teachersecondmentbean;
	}

	public QasDTeacherresearch getTeacherresearchbean() {
		return teacherresearchbean;
	}

	public void setTeacherresearchbean(QasDTeacherresearch teacherresearchbean) {
		this.teacherresearchbean = teacherresearchbean;
	}

	public QasDTeacherpublishedpaper getPublishedpaperbean() {
		return publishedpaperbean;
	}

	public void setPublishedpaperbean(QasDTeacherpublishedpaper publishedpaperbean) {
		this.publishedpaperbean = publishedpaperbean;
	}

	public QasDTeacherprocessstatistics getProcessstatisticsbean() {
		return processstatisticsbean;
	}

	public void setProcessstatisticsbean(
			QasDTeacherprocessstatistics processstatisticsbean) {
		this.processstatisticsbean = processstatisticsbean;
	}

	public QasDTeacherparttimework getParttimeworkbean() {
		return parttimeworkbean;
	}

	public void setParttimeworkbean(QasDTeacherparttimework parttimeworkbean) {
		this.parttimeworkbean = parttimeworkbean;
	}

	public QasDLessonsofteacher getLessonsofteacherbean() {
		return lessonsofteacherbean;
	}

	public void setLessonsofteacherbean(QasDLessonsofteacher lessonsofteacherbean) {
		this.lessonsofteacherbean = lessonsofteacherbean;
	}

	public QasDVirtualsimulationcenter getSimulationcenterbean() {
		return simulationcenterbean;
	}

	public void setSimulationcenterbean(
			QasDVirtualsimulationcenter simulationcenterbean) {
		this.simulationcenterbean = simulationcenterbean;
	}

	public QasDTechnologyinnovationcenter getInnovationcenterbean() {
		return innovationcenterbean;
	}

	public void setInnovationcenterbean(
			QasDTechnologyinnovationcenter innovationcenterbean) {
		this.innovationcenterbean = innovationcenterbean;
	}

	public QasDTeachingstdresearchproj getTeachingstdresearchprojbean() {
		return teachingstdresearchprojbean;
	}

	public void setTeachingstdresearchprojbean(
			QasDTeachingstdresearchproj teachingstdresearchprojbean) {
		this.teachingstdresearchprojbean = teachingstdresearchprojbean;
	}

	public QasDTeachingmanagement getTeachingmanagementbean() {
		return teachingmanagementbean;
	}

	public void setTeachingmanagementbean(
			QasDTeachingmanagement teachingmanagementbean) {
		this.teachingmanagementbean = teachingmanagementbean;
	}

	public QasDTeachingevaluation getTeachingevaluationbean() {
		return teachingevaluationbean;
	}

	public void setTeachingevaluationbean(
			QasDTeachingevaluation teachingevaluationbean) {
		this.teachingevaluationbean = teachingevaluationbean;
	}

	public QasDStudentmanagement getStudentManagementbean() {
		return studentManagementbean;
	}

	public void setStudentManagementbean(QasDStudentmanagement studentManagementbean) {
		this.studentManagementbean = studentManagementbean;
	}

	public QasDSkillmasterstudio getKillmasterstudiobean() {
		return killmasterstudiobean;
	}

	public void setKillmasterstudiobean(QasDSkillmasterstudio killmasterstudiobean) {
		this.killmasterstudiobean = killmasterstudiobean;
	}

	public QasDScholarship getScholarshipbean() {
		return scholarshipbean;
	}

	public void setScholarshipbean(QasDScholarship scholarshipbean) {
		this.scholarshipbean = scholarshipbean;
	}

	public QasDMajorsysinnovation getMajorsysinnovationbean() {
		return majorsysinnovationbean;
	}

	public void setMajorsysinnovationbean(
			QasDMajorsysinnovation majorsysinnovationbean) {
		this.majorsysinnovationbean = majorsysinnovationbean;
	}

	public QasDInnovativetrainproj getInnovativetrainprojbean() {
		return innovativetrainprojbean;
	}

	public void setInnovativetrainprojbean(
			QasDInnovativetrainproj innovativetrainprojbean) {
		this.innovativetrainprojbean = innovativetrainprojbean;
	}

	public QasDInnovationmatch getInnovationmatchbean() {
		return innovationmatchbean;
	}

	public void setInnovationmatchbean(QasDInnovationmatch innovationmatchbean) {
		this.innovationmatchbean = innovationmatchbean;
	}

	public QasDFilesofteachingmanagement getFilesOfTeachingManagebean() {
		return filesOfTeachingManagebean;
	}

	public void setFilesOfTeachingManagebean(
			QasDFilesofteachingmanagement filesOfTeachingManagebean) {
		this.filesOfTeachingManagebean = filesOfTeachingManagebean;
	}

	public QasDCooperateproject getCooperateprojectbean() {
		return cooperateprojectbean;
	}

	public void setCooperateprojectbean(QasDCooperateproject cooperateprojectbean) {
		this.cooperateprojectbean = cooperateprojectbean;
	}

	public QasDBaseinfoofteachingresearcher getTeachingResearcherbean() {
		return teachingResearcherbean;
	}

	public void setTeachingResearcherbean(
			QasDBaseinfoofteachingresearcher teachingResearcherbean) {
		this.teachingResearcherbean = teachingResearcherbean;
	}

	public QasDBaseinfoofemploymentguidance getQasDBaseGuidanceBean() {
		return qasDBaseGuidanceBean;
	}

	public void setQasDBaseGuidanceBean(
			QasDBaseinfoofemploymentguidance qasDBaseGuidanceBean) {
		this.qasDBaseGuidanceBean = qasDBaseGuidanceBean;
	}

	public QasDBaseinfoofsupervisor getQasBaseSupervisorbean() {
		return qasBaseSupervisorbean;
	}

	public void setQasBaseSupervisorbean(
			QasDBaseinfoofsupervisor qasBaseSupervisorbean) {
		this.qasBaseSupervisorbean = qasBaseSupervisorbean;
	}

	public QasTDiagnoseschemeService getDiagnoseschemeService() {
		return diagnoseschemeService;
	}

	@Autowired
	public void setDiagnoseschemeService(
			QasTDiagnoseschemeService diagnoseschemeService) {
		this.diagnoseschemeService = diagnoseschemeService;
	}

	public List<QasTDiagnosetasklevel> getDiagnosetasklevels() {
		return diagnosetasklevels;
	}

	public void setDiagnosetasklevels(List<QasTDiagnosetasklevel> diagnosetasklevels) {
		this.diagnosetasklevels = diagnosetasklevels;
	}

	public QasTDiagnosetaskdates getDiagnosetaskdates() {
		return diagnosetaskdates;
	}

	public void setDiagnosetaskdates(QasTDiagnosetaskdates diagnosetaskdates) {
		this.diagnosetaskdates = diagnosetaskdates;
	}

	public List<QasTDiagnosetaskobj> getDiagnosetaskobjlist() {
		return diagnosetaskobjlist;
	}

	public void setDiagnosetaskobjlist(List<QasTDiagnosetaskobj> diagnosetaskobjlist) {
		this.diagnosetaskobjlist = diagnosetaskobjlist;
	}

	public QasTDiagnosescheme getDiagnosescheme() {
		return diagnosescheme;
	}

	public void setDiagnosescheme(QasTDiagnosescheme diagnosescheme) {
		this.diagnosescheme = diagnosescheme;
	}

	public QasTDiagnosetaskobj getDiagnosetaskobj() {
		return diagnosetaskobj;
	}

	public void setDiagnosetaskobj(QasTDiagnosetaskobj diagnosetaskobj) {
		this.diagnosetaskobj = diagnosetaskobj;
	}

	public QasTDiagnosticreport getDiagnosticreport() {
		return diagnosticreport;
	}

	public void setDiagnosticreport(QasTDiagnosticreport diagnosticreport) {
		this.diagnosticreport = diagnosticreport;
	}

	public QasTIndicatorcatalog getQasTIndicatorcatalogBean() {
		return qasTIndicatorcatalogBean;
	}

	public void setQasTIndicatorcatalogBean(
			QasTIndicatorcatalog qasTIndicatorcatalogBean) {
		this.qasTIndicatorcatalogBean = qasTIndicatorcatalogBean;
	}

	public DecAandroidService getDecAandroidService() {
		return decAandroidService;
	}
	
	@Autowired
	public void setDecAandroidService(DecAandroidService decAandroidService) {
		this.decAandroidService = decAandroidService;
	}

	public QasTIndicatorcatalogService getQasTIndicatorcatalogService() {
		return qasTIndicatorcatalogService;
	}
	
	@Autowired
	public void setQasTIndicatorcatalogService(
			QasTIndicatorcatalogService qasTIndicatorcatalogService) {
		this.qasTIndicatorcatalogService = qasTIndicatorcatalogService;
	}

/*	public QasTDiagnosetaskService getDiagnosetaskService() {
		return diagnosetaskService;
	}
	
	@Autowired
	public void setDiagnosetaskService(QasTDiagnosetaskService diagnosetaskService) {
		this.diagnosetaskService = diagnosetaskService;
	}*/

	public TRmsMenuinfoService gettRmsMenuinfoService() {
		return tRmsMenuinfoService;
	}
	
	@Autowired
	public void settRmsMenuinfoService(TRmsMenuinfoService tRmsMenuinfoService) {
		this.tRmsMenuinfoService = tRmsMenuinfoService;
	}

	public String getTransId() {
		return transId;
	}

	public void setTransId(String transId) {
		this.transId = transId;
	}

	public QasTDiagnosetask getDiagnosetask() {
		return diagnosetask;
	}
	
	public void setDiagnosetask(QasTDiagnosetask diagnosetask) {
		this.diagnosetask = diagnosetask;
	}

	public List getDatas() {
		return datas;
	}

	public QasDCourse getCouesebean() {
		return couesebean;
	}

	public void setCouesebean(QasDCourse couesebean) {
		this.couesebean = couesebean;
	}

	public void setDatas(List datas) {
		this.datas = datas;
	}

	public QasDEmpolyee getEmpolyeebean() {
		return empolyeebean;
	}

	public void setEmpolyeebean(QasDEmpolyee empolyeebean) {
		this.empolyeebean = empolyeebean;
	}

	public QasDGrade getGradebean() {
		return gradebean;
	}

	public void setGradebean(QasDGrade gradebean) {
		this.gradebean = gradebean;
	}

	public QasDFundcoststatistics getFundcosbean() {
		return fundcosbean;
	}

	public void setFundcosbean(QasDFundcoststatistics fundcosbean) {
		this.fundcosbean = fundcosbean;
	}

	public QasDStudent getStudentbean() {
		return studentbean;
	}

	public void setStudentbean(QasDStudent studentbean) {
		this.studentbean = studentbean;
	}

	public QasDCoursematerial getCoursematerialbean() {
		return Coursematerialbean;
	}

	public void setCoursematerialbean(QasDCoursematerial coursematerialbean) {
		Coursematerialbean = coursematerialbean;
	}

	public QasDCooperatecompany getCooperatecompanybean() {
		return cooperatecompanybean;
	}

	public void setCooperatecompanybean(QasDCooperatecompany cooperatecompanybean) {
		this.cooperatecompanybean = cooperatecompanybean;
	}

	public QasDCooperate getCooperatebean() {
		return cooperatebean;
	}

	public void setCooperatebean(QasDCooperate cooperatebean) {
		this.cooperatebean = cooperatebean;
	}

	public QasDFundincomestatistics getFundincomesbean() {
		return fundincomesbean;
	}

	public void setFundincomesbean(QasDFundincomestatistics fundincomesbean) {
		this.fundincomesbean = fundincomesbean;
	}

	public QasDDirectionstatistics getDirectionstatisticsbean() {
		return Directionstatisticsbean;
	}

	public void setDirectionstatisticsbean(
			QasDDirectionstatistics directionstatisticsbean) {
		Directionstatisticsbean = directionstatisticsbean;
	}

	public QasDPractice getPracticebean() {
		return practicebean;
	}

	public void setPracticebean(QasDPractice practicebean) {
		this.practicebean = practicebean;
	}

	public QasDMajorqualitativeindicator getMajorqualitativeindicatorbean() {
		return majorqualitativeindicatorbean;
	}

	public void setMajorqualitativeindicatorbean(
			QasDMajorqualitativeindicator majorqualitativeindicatorbean) {
		this.majorqualitativeindicatorbean = majorqualitativeindicatorbean;
	}

	public QasDMajorleader getMajorleaderbean() {
		return majorleaderbean;
	}

	public void setMajorleaderbean(QasDMajorleader majorleaderbean) {
		this.majorleaderbean = majorleaderbean;
	}

	public QasDMajorcourse getMajorcoursebean() {
		return majorcoursebean;
	}

	public void setMajorcoursebean(QasDMajorcourse majorcoursebean) {
		this.majorcoursebean = majorcoursebean;
	}

	public QasDLastyearemployment getLastyearemploymentbean() {
		return lastyearemploymentbean;
	}

	public void setLastyearemploymentbean(
			QasDLastyearemployment lastyearemploymentbean) {
		this.lastyearemploymentbean = lastyearemploymentbean;
	}

	public QasDGraduateinformation getGraduateinformationbean() {
		return graduateinformationbean;
	}

	public void setGraduateinformationbean(
			QasDGraduateinformation graduateinformationbean) {
		this.graduateinformationbean = graduateinformationbean;
	}

	public QasDGraduateemploymentunits getGraduateemploymentunitsbean() {
		return graduateemploymentunitsbean;
	}

	public void setGraduateemploymentunitsbean(
			QasDGraduateemploymentunits graduateemploymentunitsbean) {
		this.graduateemploymentunitsbean = graduateemploymentunitsbean;
	}

	public QasDGraduateemployment getGraduateemploymentbean() {
		return graduateemploymentbean;
	}

	public void setGraduateemploymentbean(
			QasDGraduateemployment graduateemploymentbean) {
		this.graduateemploymentbean = graduateemploymentbean;
	}

	public QasDFixedassets getFixedassetsbean() {
		return fixedassetsbean;
	}

	public void setFixedassetsbean(QasDFixedassets fixedassetsbean) {
		this.fixedassetsbean = fixedassetsbean;
	}

	public QasDSchoolcontacter getSchoolcontacterbean() {
		return schoolcontacterbean;
	}

	public void setSchoolcontacterbean(QasDSchoolcontacter schoolcontacterbean) {
		this.schoolcontacterbean = schoolcontacterbean;
	}

	public QasDCollegeinschoolstudent getCollegeinschoolstudentbean() {
		return collegeinschoolstudentbean;
	}

	public void setCollegeinschoolstudentbean(
			QasDCollegeinschoolstudent collegeinschoolstudentbean) {
		this.collegeinschoolstudentbean = collegeinschoolstudentbean;
	}

	public QasDCollegeenroltype getCollegeenroltypebean() {
		return collegeenroltypebean;
	}

	public void setCollegeenroltypebean(QasDCollegeenroltype collegeenroltypebean) {
		this.collegeenroltypebean = collegeenroltypebean;
	}

	public QasDCollegeenrolplan getCollegeenrolplanbean() {
		return collegeenrolplanbean;
	}

	public void setCollegeenrolplanbean(QasDCollegeenrolplan collegeenrolplanbean) {
		this.collegeenrolplanbean = collegeenrolplanbean;
	}

	public QasDBooksinlibrary getBooksinlibrarybean() {
		return booksinlibrarybean;
	}

	public void setBooksinlibrarybean(QasDBooksinlibrary booksinlibrarybean) {
		this.booksinlibrarybean = booksinlibrarybean;
	}

	public QasDAreaofstructure getAreaofstructurebean() {
		return areaofstructurebean;
	}

	public void setAreaofstructurebean(QasDAreaofstructure areaofstructurebean) {
		this.areaofstructurebean = areaofstructurebean;
	}

	public QasDRecruit getRecruitbean() {
		return recruitbean;
	}

	public void setRecruitbean(QasDRecruit recruitbean) {
		this.recruitbean = recruitbean;
	}

	public QasDPracticebaseincampus getPracticebaseincampusbean() {
		return Practicebaseincampusbean;
	}

	public void setPracticebaseincampusbean(
			QasDPracticebaseincampus practicebaseincampusbean) {
		Practicebaseincampusbean = practicebaseincampusbean;
	}

	public QasDOrganizationstatistics getOrganizationstatisticsbean() {
		return Organizationstatisticsbean;
	}

	public void setOrganizationstatisticsbean(
			QasDOrganizationstatistics organizationstatisticsbean) {
		Organizationstatisticsbean = organizationstatisticsbean;
	}

	public QasDManagementinformationsystem getManagementinformationsystembean() {
		return Managementinformationsystembean;
	}

	public void setManagementinformationsystembean(
			QasDManagementinformationsystem managementinformationsystembean) {
		Managementinformationsystembean = managementinformationsystembean;
	}

	public QasDLeaderaction getLeaderactionbean() {
		return Leaderactionbean;
	}

	public void setLeaderactionbean(QasDLeaderaction leaderactionbean) {
		Leaderactionbean = leaderactionbean;
	}

	public QasDInformationconstruction getInformationconstructionbean() {
		return Informationconstructionbean;
	}

	public void setInformationconstructionbean(
			QasDInformationconstruction informationconstructionbean) {
		Informationconstructionbean = informationconstructionbean;
	}

	public QasDSkillappraisalorgstatistics getSkillappraisalorgstatisticsbean() {
		return Skillappraisalorgstatisticsbean;
	}

	public void setSkillappraisalorgstatisticsbean(
			QasDSkillappraisalorgstatistics skillappraisalorgstatisticsbean) {
		Skillappraisalorgstatisticsbean = skillappraisalorgstatisticsbean;
	}

	public QasDSkillappraisalorg getSkillappraisalorgbean() {
		return Skillappraisalorgbean;
	}

	public void setSkillappraisalorgbean(QasDSkillappraisalorg skillappraisalorgbean) {
		Skillappraisalorgbean = skillappraisalorgbean;
	}

	public QasDShoolaward getShoolawardbean() {
		return Shoolawardbean;
	}

	public void setShoolawardbean(QasDShoolaward shoolawardbean) {
		Shoolawardbean = shoolawardbean;
	}

	public QasDSchool getSchoolbean() {
		return Schoolbean;
	}

	public void setSchoolbean(QasDSchool schoolbean) {
		Schoolbean = schoolbean;
	}

	public QasDRooms getRoomsbean() {
		return Roomsbean;
	}

	public void setRoomsbean(QasDRooms roomsbean) {
		Roomsbean = roomsbean;
	}

	public QasDPracticebaseincampusstatistics getPracticebaseincampusstatisticsbean() {
		return Practicebaseincampusstatisticsbean;
	}

	public void setPracticebaseincampusstatisticsbean(
			QasDPracticebaseincampusstatistics practicebaseincampusstatisticsbean) {
		Practicebaseincampusstatisticsbean = practicebaseincampusstatisticsbean;
	}

	public ICommonService getiCommonService() {
		return iCommonService;
	}
	
	public String getInitStatus() {
		return initStatus;
	}

	public void setInitStatus(String initStatus) {
		this.initStatus = initStatus;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public QasDTrainingbaseoutofcampusstatistics getTrainingbaseoutofcampusstatisticsbean() {
		return trainingbaseoutofcampusstatisticsbean;
	}

	public void setTrainingbaseoutofcampusstatisticsbean(
			QasDTrainingbaseoutofcampusstatistics trainingbaseoutofcampusstatisticsbean) {
		this.trainingbaseoutofcampusstatisticsbean = trainingbaseoutofcampusstatisticsbean;
	}

	public String[] getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String[] newPassword) {
		this.newPassword = newPassword;
	}

	@Autowired
	@Qualifier("commonService")
	public void setiCommonService(ICommonService iCommonService) {
		this.iCommonService = iCommonService;
	}

	public QasDTrainingbaseoutofcampus getTrainingbaseoutofcampusbean() {
		return Trainingbaseoutofcampusbean;
	}

	public void setTrainingbaseoutofcampusbean(
			QasDTrainingbaseoutofcampus trainingbaseoutofcampusbean) {
		Trainingbaseoutofcampusbean = trainingbaseoutofcampusbean;
	}

	public QasDSocialdonation getSocialdonationbean() {
		return Socialdonationbean;
	}

	public void setSocialdonationbean(QasDSocialdonation socialdonationbean) {
		Socialdonationbean = socialdonationbean;
	}
	
	
	
}
