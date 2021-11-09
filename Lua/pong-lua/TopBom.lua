TopBom = Class{}

--initialize a paddle 
function TopBom:init(x,y,width,height)
    self.x=x
    self.y=y
    self.width=width
    self.height=height

end
--update my paddle 
function TopBom:update(dt)
    if self.dx <0 then
        self.x =math.max(0,self.x+self.dx*dt)
    else
        self.x =math.min(VIRTUAL_HEIGHT-self.height,self.x+self.dx*dt)
    end
end
--render my paddle 
function TopBom:render()
    love.graphics.rectangle('fill',self.x,self.y,self.width,self.height)
end