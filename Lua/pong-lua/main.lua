push = require 'push'
Class = require 'class'

require 'TopBom'
require 'Ball'
require 'Paddle'
WINDOW_WIDTH=720
WINDOW_HEIGHT=720

VIRTUAL_WIDTH=432
VIRTUAL_HEIGHT=432

--Speed at which we will move the paddles; multipled by dt in updateFunction 
PADDLE_SPEED=200
--Create a function to stat up the window that intialize the game 


function love.load()
    --"seed " the RNG so that calls to random are always random
    --utilizing the current time, since that will vary on start up 
    math.randomseed(os.time())
    love.window.setTitle("Pong")



    --nearest-neightbor filtering on upscalling and downscaling to prevent blurriness 
    love.graphics.setDefaultFilter('nearest', 'nearest')

    -- var  = module.module. method('fileName'fontSize)
    smallFont=love.graphics.newFont('font.ttf',8)
    scoreFont=love.graphics.newFont('font.ttf',20)
    love.graphics.setFont(smallFont)

    --set up or sound effects in "Table" or a "Hash map" or a "Dictionary"
    sounds={
        --['key']   = value
        --['paddle_hit']=love.audio.newSource('Sounds/paddle_hit.wav','static'),
        --['score']=love.audio.newSource('Sounds/score.wav','static'),
        --['wall_hit']=love.audio.newSource('Sounds/wall_hit.wav','static')
    }

    -- initalized our virtual resolution, which is rendered inside of our actual window
    push:setupScreen(VIRTUAL_WIDTH,VIRTUAL_HEIGHT,WINDOW_WIDTH,WINDOW_HEIGHT,{
        fullscreen=false,
        resizable=false,
        vsync=true
    })
    --score values: render these scores on the screen 
    player1Score=7
    player2Score=7
    player3Score=7
    player4Score=7

    --either going to be 1 or 2; whomever is scored on gets to serve the following turn
    servingPlayer=1


    --paddle postion on the y axis 
    player1=Paddle(10,30,5,20)
    player2=Paddle(VIRTUAL_WIDTH-10,VIRTUAL_HEIGHT-30,5,20)
    player3=TopBom(30,10,20,5)
    player4=TopBom(VIRTUAL_HEIGHT-30,VIRTUAL_WIDTH -40,20,5)

    -- object ball =Ball(x,y,width,height)
    ball=Ball(VIRTUAL_WIDTH/2-2,VIRTUAL_HEIGHT/2-2,4,4)

    --math.random retunr a random value between the 1st and 2nd value
    -- the direction fo the ball
    
    
    --we start at a 'start ' state so no movement 
    gameState= 'start'
end
function love.resize(w,h)
    push:resize(w,h)
end
    --[[
        Called by love whenever we resize the screen. takes in the width and height
        to "push" pour virtual resoultion to the new width and height 
    ]]
-- runs every frame, with "dt" passes in, out delta in seconds since the last frame.
function love.update(dt)
    if gameState=='serve' then
        --before switching to play. intialize ball's velocity
        ball.dy = math.random(-50,50)
          if servingPlayer==1 then
               ball.dx = math.random(140,200)
          elseif servingPlayer==2 then
               ball.dx = -math.random(140,200)
          elseif servingPlayer==3 then
               ball.dy = math.random(140,200)
          elseif servingPlayer==4 then
               ball.dy = -math.random(140,200)
          end
     elseif gameState == 'play' then
          --[[
               detech ball collision with paddles,
                    reversing dx if true and slightly increasing the speed(dx)
                    altering the dy based on the position of collision
          ]]
          if ball:collides(player1) then
               ball.dx = -ball.dx * 2     --increased the speed
               ball.x = player1.x +5         --moving back to not bounce in the paddle
               --keep velocity going in the same direction, but randomize it
               if ball.dy < 0 then
                    ball.dy = -math.random(10,150)
               else 
                    ball.dy = math.random(10,150)
               end
          end
          if ball:collides(player2) then
               ball.dx = -ball.dx * 2   --increase the speed
               ball.x = player2.x - 4         --moving back to not bounce in the paddle
               --keep  it going in the same direction
               if ball.dy < 0 then
                    ball.dy = -math.random(10,150)
               else 
                    ball.dy = math.random(10,150)
               end
          end
          if ball:collides(player3) then
               ball.dy = -ball.dy * 2  --increase the speed
               ball.y = player3.y +5         --moving back to not bounce in the paddle
               --keep  it going in the same direction
               if ball.dy < 0 then
                    ball.dy = -math.random(10,150)
               else 
                    ball.dy = math.random(10,150)
               end
          end
          if ball:collides(player4) then
               ball.dy = -ball.dy * 2    --increase the speed
               ball.y = player4.y - 4         
               --keep  it going in the same direction
               if ball.dy < 0 then
                    ball.dy = -math.random(10,150)
               else 
                    ball.dy = math.random(10,150)
               end
          end
          
          --going past the left side 
          if ball.x < 0 then
               servingPlayer = 2
               player1Score = player1Score - 1
               if player1Score == 0 then
                    losingPlayer=1
                    gameState = 'done'
               else
                    gameState='serve'
                    ball:reset(player1Score)
               end
          end
          --going past the right side 
          if ball.x > VIRTUAL_WIDTH then
               servingPlayer = 1
               player2Score = player2Score - 1
               if player2Score == 0 then
                    losingPlayer=2
                    gameState = 'done'
               else
                    gameState='serve'
                    ball:reset(player2)
               end
          end
          --going past the top side 
          if ball.y < 0 then
               servingPlayer = 4
               player3Score = player3Score - 1
               if player3Score == 0 then
                    losingPlayer=3
                    gameState = 'done'
               else
                    gameState='serve'
                    ball:reset(player3)
               end
          end
          --going past the bottom side 
          if ball.y > VIRTUAL_HEIGHT then
               servingPlayer = 3
               player4Score = player4Score - 1
               if player4Score == 0 then
                    losingPlayer=4
                    gameState = 'done'
               else
                    gameState='serve'
                    ball:reset(player4)
               end
          end
        ball:update(dt)
        --  1 movement
        if love.keyboard.isDown('w') then
             player1.dy = -PADDLE_SPEED
        elseif love.keyboard.isDown('s') then
             player1.dy = PADDLE_SPEED
        else
             player1.dy = 0
        end
        -- player 2 movement
        if love.keyboard.isDown('up') then
             player2.dy = -PADDLE_SPEED
        elseif love.keyboard.isDown('down') then
             player2.dy = PADDLE_SPEED
        else
             player2.dy = 0
        end
        -- player 3 movement
        if love.keyboard.isDown('a') then
             player3.dx = -PADDLE_SPEED
        elseif love.keyboard.isDown('d') then
             player3.dx = PADDLE_SPEED
        else
             player3.dx = 0
        end
        -- player 4 movement
        if love.keyboard.isDown('left') then
             player4.dx = -PADDLE_SPEED
        elseif love.keyboard.isDown('right') then
             player4.dx = PADDLE_SPEED
        else
             player4.dx = 0
        end
        player1:update(dt)
        player2:update(dt)
        player3:update(dt)
        player4:update(dt)
   end
end





    

--[[
    Keyboard handling, called by LOVE2D each frame;
        passes in the key we presses so we can access.
]]
function love.keypressed(key)
    if key == 'escape' then 
        love.event.quit()
    elseif key == 'enter' or key== 'return' then
        if gameState =='start' then
            gameState='serve'
        elseif gameState=='serve' then
            gameState='play'
        elseif gameState=='done' then
            gameState='serve'
            ball:reset()
            player1Score=7
            player2Score=7
            player3Score=7
            player4Score=7
            if losingPlayer ==1 then
                servingPlayer =1
            elseif losingPlayer==2 then 
                servingPlayer =2  
            elseif losingPlayer ==3 then 
                servingPlayer =3
            elseif losingPlayer ==4 then 
                servingPlayer =4
            end
        end
    end 
end

--update the screen with information: draw anything that is needed 
--function module.draw()
function love.draw()
    --begin reading a virt resoultion 
    push:apply('start')

    --clear the screen with a specific color 
    --love.graphics.clear(R,G,B,A)
    love.graphics.clear(40,45,52,255)
    love.graphics.setFont(smallFont)
    if gameState == 'start' then
     love.graphics.printf('Welcome to Pong ', 0, 10, VIRTUAL_WIDTH, 'center')
     love.graphics.printf('Press Enter to begin', 0, 30, VIRTUAL_WIDTH, 'center')
     love.graphics.printf("Player 1 is Left", 0, 40, VIRTUAL_WIDTH, 'center')
     love.graphics.printf("Player 2 is Right", 0, 50, VIRTUAL_WIDTH, 'center')
     love.graphics.printf("Player 3 is Top", 0, 60, VIRTUAL_WIDTH, 'center')
     love.graphics.printf("Player 4 is Bottom", 0, 68, VIRTUAL_WIDTH, 'center')

     elseif gameState == 'serve' then
          love.graphics.printf('Player ' .. tostring(servingPlayer) .. "'s  is serving!",
                0, 20, VIRTUAL_WIDTH, 'center')
     elseif gameState == 'play' then
          --no message because we are playing
     elseif gameState == 'done' then
          love.graphics.setFont(scoreFont)
          love.graphics.printf('Player ' .. tostring(losingPlayer) .. " lost!",
                    0, 30, VIRTUAL_WIDTH, 'center')
          love.graphics.setFont(smallFont)
          love.graphics.printf('Press Enter to restart',0, 20, VIRTUAL_WIDTH, 'center')
end
    love.graphics.setFont(scoreFont)
    love.graphics.print(tostring(player1Score),VIRTUAL_WIDTH/2-60,VIRTUAL_HEIGHT/3)
    love.graphics.print(tostring(player2Score),VIRTUAL_WIDTH/2+50,VIRTUAL_HEIGHT/3)
    love.graphics.print(tostring(player3Score),VIRTUAL_WIDTH/2,VIRTUAL_HEIGHT/6)
    love.graphics.print(tostring(player4Score),VIRTUAL_WIDTH/2,VIRTUAL_HEIGHT/1.4)
    player1:render()
    player2:render()
    player3:render()
    player4:render()
    ball:render()
    displayFPS()
    --end rendering at virtual resoultion 
    push:apply('end')
end

function displayFPS()
    love.graphics.setFont(smallFont)
    love.graphics.setColor(255,0,0,255)
    love.graphics.print("Current FPS: "..tostring(love.timer.getFPS( )), 10, 10)
end