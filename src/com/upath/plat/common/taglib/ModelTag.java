package com.upath.plat.common.taglib;


@SuppressWarnings("serial")
public class ModelTag extends BaseTage {

	private String modelId;
	
	private String stepModelId;
	
	
	/*public int doEndTag() throws JspException {
		
		IWorkflowModel model = WorkflowCacheManager.getInstance().getWorkflowModel(modelId);
			if(model != null){
				if(stepModelId != null && "".equals(stepModelId) == false){
						IStepModel stepModel = model.getStepModel(stepModelId);
						if(stepModel != null){
							bindScopeData(this.var,stepModel);
						}
				}else{
					bindScopeData(this.var, model);
				}
			}
		return SKIP_BODY;
	}*/


	public String getModelId() {
		return modelId;
	}


	public void setModelId(String modelId) {
		this.modelId = modelId;
	}


	public String getStepModelId() {
		return stepModelId;
	}


	public void setStepModelId(String stepModelId) {
		this.stepModelId = stepModelId;
	}
}
